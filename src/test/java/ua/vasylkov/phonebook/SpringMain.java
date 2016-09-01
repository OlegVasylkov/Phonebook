package ua.vasylkov.phonebook;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.vasylkov.phonebook.repository.UserRepository;
import ua.vasylkov.phonebook.web.contact.ContactRestController;
import ua.vasylkov.phonebook.web.user.AdminRestController;

import java.util.Arrays;

import static ua.vasylkov.phonebook.UserTestData.ADMIN;

/**
 * Created by OlegVasylkov on 09.08.2016.
 */
public class SpringMain {
    public static void main(String[] args) {
        try
                (ConfigurableApplicationContext applicationContext =
                         new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
            UserRepository userRepository = applicationContext.getBean(UserRepository.class);
            AdminRestController adminRestController = applicationContext.getBean(AdminRestController.class);
            System.out.println(adminRestController.create(ADMIN));

            ContactRestController contactRestController = applicationContext.getBean(ContactRestController.class);
            System.out.println(contactRestController.getFiltered("098"));
        }
    }
}
