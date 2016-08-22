package ua.vasylkov.phonebook.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ua.vasylkov.phonebook.model.User;
import ua.vasylkov.phonebook.repository.UserRepository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by OlegVasylkov on 19.08.2016.
 */
@Repository
public class JdbcUserRepositoryImpl implements UserRepository {
    private static final BeanPropertyRowMapper<User> ROW_MAPPER =
            BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertUser;

    @Autowired
    public JdbcUserRepositoryImpl(DataSource dataSource){
        this.insertUser = new SimpleJdbcInsert(dataSource)
                .withTableName("USERS")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public User save(User user) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("name", user.getName())
                .addValue("login", user.getLogin())
                .addValue("password", user.getPassword());
        if (user.isNew()){
            Number key = insertUser.executeAndReturnKey(map);
            user.setId(key.intValue());
        }else {
            namedParameterJdbcTemplate.update(
                    "UPDATE users SET name=:name, login=:login, password=:password" +
                            "WHERE id=:id", map);
        }
        return user;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id=?", id) != 0;
    }

    @Override
    public User get(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users " +
                "WHERE id=?", ROW_MAPPER, id);
    }

    @Override
    public User getByLogin(String login) {
        return jdbcTemplate.queryForObject("SELECT * FROM users " +
                "WHERE login=?", ROW_MAPPER, login);
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY name, login", ROW_MAPPER);
    }
}