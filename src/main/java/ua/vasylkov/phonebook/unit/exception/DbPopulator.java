package ua.vasylkov.phonebook.unit.exception;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import javax.xml.ws.soap.Addressing;

/**
 * Created by OlegVasylkov on 23.08.2016.
 */
public class DbPopulator extends ResourceDatabasePopulator {
    private static final ResourceLoader RESOURCE_LOADER = new DefaultResourceLoader();

    @Addressing
    private DataSource dataSource;

    public DbPopulator(String scriptLocation){
        super(RESOURCE_LOADER.getResource(scriptLocation));
    }

    public void execute(){
        DatabasePopulatorUtils.execute(this, dataSource);
    }
}