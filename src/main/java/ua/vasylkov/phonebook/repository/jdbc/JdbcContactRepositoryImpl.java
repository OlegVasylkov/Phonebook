package ua.vasylkov.phonebook.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ua.vasylkov.phonebook.model.Contact;
import ua.vasylkov.phonebook.repository.ContactRepository;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;

/**
 * Created by OlegVasylkov on 23.08.2016.
 */
@Repository
public class JdbcContactRepositoryImpl implements ContactRepository {

    private static final BeanPropertyRowMapper<Contact> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Contact.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertContact;

    @Autowired
    public JdbcContactRepositoryImpl(DataSource dataSource){
        this.insertContact = new SimpleJdbcInsert(dataSource)
                .withTableName("contacts")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Contact save(Contact contact, int userId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", contact.getId())
                .addValue("user_id", userId)
                .addValue("lastName", contact.getLastName())
                .addValue("firstName", contact.getFirstName())
                .addValue("middleName", contact.getMiddleName())
                .addValue("mobilePhone", contact.getMobilePhone())
                .addValue("homePhone", contact.getHomePhone())
                .addValue("address", contact.getAddress())
                .addValue("email", contact.getEmail());
        if (contact.isNew()){
            Number key = insertContact.executeAndReturnKey(map);
            contact.setId(key.intValue());
        }else {
            if(namedParameterJdbcTemplate.update(
                    "UPDATE contacts" +
                    " SET lastname=:lastName, firstname=:firstName, middlename=:middleName, " +
                    "mobilephone=:mobilePhone, homephone=:homePhone, address=:address, email=:email " +
                    "WHERE id=:id AND user_id=user_Id", map) == 0)
                return null;
        }
        return contact;
    }

    @Override
    public boolean delete(int id, int userId) {

        return jdbcTemplate.update("DELETE FROM contacts WHERE id=? AND user_id=?", id, userId) != 0;
    }

    @Override
    public Contact get(int id, int userId) {
        List<Contact> contacts = jdbcTemplate.query("SELECT * FROM contacts WHERE id=? AND user_id=?", ROW_MAPPER, id, userId);
        return DataAccessUtils.singleResult(contacts);
    }

    @Override
    public Collection<Contact> getAll(int userId) {
        return jdbcTemplate.query("SELECT * FROM contacts WHERE user_id=? ORDER BY lastname, firstname",
                ROW_MAPPER, userId);
    }

    @Override
    public Collection<Contact> getFiltered(String search, int userId) {
        return jdbcTemplate.query("SELECT * FROM contacts " +
                "WHERE user_id=? AND " +
                "lastname LIKE ? " +
                "OR firstname LIKE ? " +
                "OR middlename LIKE ? " +
                "OR mobilephone LIKE ? " +
                "OR homephone LIKE ? ORDER BY lastname, firstname", ROW_MAPPER, userId,
                search + "%",
                search + "%",
                search + "%",
                "%" + search + "%",
                "%" + search + "%");
    }
}