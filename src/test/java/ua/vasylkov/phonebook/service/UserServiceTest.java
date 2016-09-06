package ua.vasylkov.phonebook.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vasylkov.phonebook.UserTestData.TestUser;
import ua.vasylkov.phonebook.model.Role;
import ua.vasylkov.phonebook.model.User;
import ua.vasylkov.phonebook.unit.exception.NotFoundException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static ua.vasylkov.phonebook.UserTestData.USER_MATCHER;
import static ua.vasylkov.phonebook.UserTestData.*;

/**
 * Created by OlegVasylkov on 23.08.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceTest {
    @Autowired
    protected UserService userService;

    @Test
    public void testGet() throws Exception{
        User user = userService.get(USER_ID);
        USER_MATCHER.assertEquals(USER, user);
    }

    @Test
    public void testSave() throws Exception{
        TestUser tu = new TestUser(null, "asdfsd", "adsfasd", "adsfasdf", Collections.singleton(Role.ROLE_USER));
        User created = userService.save(tu.asUser());
        tu.setId(created.getId());
        USER_MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, tu, USER), userService.getAll());
    }

    @Test
    public void testDuplicateLogin() throws Exception{
        userService.save(new TestUser("dupicate", "userLogin", "asdfasf", Role.ROLE_USER).asUser());
    }

    @Test
    public void testDelete() throws Exception{
        userService.delete(USER_ID);
        USER_MATCHER.assertCollectionEquals(Collections.singleton(ADMIN), userService.getAll());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFound() throws Exception{
        userService.delete(1);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception{
        userService.get(1);
    }

    @Test
    public void testGetByLogin() throws Exception{
        User user = userService.getByLogin("admin");
        USER_MATCHER.assertEquals(ADMIN, user);
    }

    @Test
    public void testGetAll() throws Exception{
        Collection<User> all = userService.getAll();
        USER_MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, USER), all);
    }

    @Test
    public void testUpdate() throws Exception{
        TestUser updated = new TestUser(USER);
        updated.setName("UpdatedName");
        userService.update(updated.asUser());
        USER_MATCHER.assertEquals(updated, userService.get(USER_ID));
    }
}