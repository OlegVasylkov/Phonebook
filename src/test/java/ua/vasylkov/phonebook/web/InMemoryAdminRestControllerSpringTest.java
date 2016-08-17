package ua.vasylkov.phonebook.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vasylkov.phonebook.model.User;
import ua.vasylkov.phonebook.repository.UserRepository;
import ua.vasylkov.phonebook.unit.exception.NotFoundException;
import ua.vasylkov.phonebook.web.user.AdminRestController;

import java.util.Collection;

import static ua.vasylkov.phonebook.UserTestData.ADMIN;
import static ua.vasylkov.phonebook.UserTestData.USER;
import static ua.vasylkov.phonebook.UserTestData.USER_ID;

/**
 * Created by OlegVasylkov on 17.08.2016.
 */

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class InMemoryAdminRestControllerSpringTest {
    @Autowired
    private AdminRestController controller;

    @Autowired
    private UserRepository repository;

    @Before
    public void setUp() throws Exception{
        repository.getAll().forEach(user -> repository.delete(user.getId()));
        repository.save(USER);
        repository.save(ADMIN);
    }

    @Test
    public void testDelete() throws Exception {
        controller.delete(USER_ID);
        Collection<User> users = controller.getAll();
        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.iterator().next(), ADMIN);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        controller.delete(10);
    }

}
