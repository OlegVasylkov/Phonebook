package ua.vasylkov.phonebook.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.vasylkov.phonebook.repository.UserRepository;

/**
 * Created by OlegVasylkov on 09.08.2016.
 */
public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(applicationContext.getBeanDefinitionNames());

        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        userRepository.getAll();
        applicationContext.close();
    }
}
