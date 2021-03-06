package ua.vasylkov.phonebook.web;

import org.junit.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.vasylkov.phonebook.model.Role;
import ua.vasylkov.phonebook.model.User;
import ua.vasylkov.phonebook.repository.UserRepository;
import ua.vasylkov.phonebook.unit.exception.NotFoundException;
import ua.vasylkov.phonebook.web.user.AdminRestController;

import java.util.Arrays;
import java.util.List;

import static ua.vasylkov.phonebook.UserTestData.*;

/**
 * Created by OlegVasylkov on 17.08.2016.
 */
public class InMemoryAdminRestControllerTest {
    private static ConfigurableApplicationContext appCtx;
    private static AdminRestController controller;

    @BeforeClass
    public static void beforeClass(){
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/mock.xml");
        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
        controller = appCtx.getBean(AdminRestController.class);
    }

    @AfterClass
    public static void afterClass(){
        appCtx.close();
    }

    @Before
    public void setUp() throws Exception {
        // Re-initialize
        UserRepository repository = appCtx.getBean(UserRepository.class);
        repository.getAll().forEach(u -> repository.delete(u.getId()));
        repository.save(USER);
        repository.save(ADMIN);
    }
    @Test
    public void getAll() throws Exception {
        List<User> users = controller.getAll();
        Assert.assertEquals(2, users.size());
    }

    @Test
    public void get() throws Exception {
        User user = controller.get(ADMIN_ID);
        Assert.assertEquals(user, ADMIN);
    }

    @Test
    public void create() throws Exception {
        User user = new User(null, "asdfas", "asdfasd", "asdfasd", Role.ROLE_USER);
        User user1 = controller.create(user);
        Assert.assertEquals(user1, user);
    }

    @Test
    public void delete() throws Exception {
        controller.delete(USER_ID);
        List<User> users = controller.getAll();
        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.iterator().next(), ADMIN);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound(){
        controller.delete(10);
    }
}