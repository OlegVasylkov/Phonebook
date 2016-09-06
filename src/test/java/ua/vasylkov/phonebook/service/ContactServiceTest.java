package ua.vasylkov.phonebook.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vasylkov.phonebook.model.Contact;
import ua.vasylkov.phonebook.unit.exception.NotFoundException;

import java.util.Arrays;
import java.util.Collections;

import static ua.vasylkov.phonebook.ContactTestData.*;
import static ua.vasylkov.phonebook.UserTestData.ADMIN_ID;
import static ua.vasylkov.phonebook.UserTestData.USER_ID;

/**
 * Created by OlegVasylkov on 01.09.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class ContactServiceTest {
    @Autowired
    private ContactService service;

    @Test
    public void testGet()throws Exception{
        Contact contact = service.get(CONTACT_ID, USER_ID);
        Assert.assertEquals(contact, CONTACT1);
    }

    @Test
    public void testGetAll()throws Exception{
        CONTACT_MATCHER.assertCollectionEquals(USER_CONTACTS, service.getAll(USER_ID));
    }
    @Test
    public void testSave() throws Exception{
        Contact contact = getCreated();
        service.save(contact, USER_ID);
        CONTACT_MATCHER.assertCollectionEquals(Arrays.asList(CONTACT2, contact, CONTACT1), service.getAll(USER_ID));
    }
    @Test
    public void testUpdate() throws Exception{
        Contact contact = getUpdate();
        service.update(contact, USER_ID);
        CONTACT_MATCHER.assertEquals(contact, service.get(CONTACT_ID, USER_ID));
    }
    @Test
    public void testSearch() throws Exception{
        CONTACT_MATCHER.assertCollectionEquals(Arrays.asList(ADMIN_CONTACT2, ADMIN_CONTACT), service.getFiltered("312", ADMIN_ID));
    }
    @Test
    public void testDelete() throws Exception{
        service.delete(CONTACT_ID, USER_ID);
        CONTACT_MATCHER.assertCollectionEquals(Collections.singletonList(CONTACT2), service.getAll(USER_ID));
    }
    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception{
        service.delete(CONTACT_ID, 1);
    }
}