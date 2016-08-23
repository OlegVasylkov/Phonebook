package ua.vasylkov.phonebook.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vasylkov.phonebook.unit.exception.DbPopulator;

/**
 * Created by OlegVasylkov on 23.08.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @Autowired
    protected UserService userService;
    @Autowired
    private DbPopulator dbPopulator;
}
