package com.buetian.gamearena.tests.util;

import org.junit.ClassRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;

import javax.sql.DataSource;

@ContextConfiguration(initializers = {DBHelper.Initializer.class})
public abstract class DBHelper {

    @Autowired
    DataSource dataSource;

    @ClassRule
    public static MySQLContainer mySQLContainer = (MySQLContainer) new MySQLContainer("mysql:8.0")
            .withDatabaseName("coreapp")
            .withUsername("root")
            .withPassword("root")
            .withReuse(true);

    public static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            System.out.println("Starting the test container.....");
            mySQLContainer.start();
            TestPropertyValues.of(
                    "spring.datasource.url=" + mySQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + mySQLContainer.getUsername(),
                    "spring.datasource.password=" + mySQLContainer.getPassword(),
                    "spring.datasource.driver-class-name=" + mySQLContainer.getDriverClassName()
            ).applyTo(configurableApplicationContext.getEnvironment());
            //resetDb("coreapp");
        }
    }

    protected void resetDbCoreapp() {
        resetDb("coreapp");
    }

    protected void resetDb(String dbName) {
        ClassPathResource schemaResource = new ClassPathResource(String.format("db/%s/schema.sql", dbName));
        ResourceDatabasePopulator schemaPopulator = new ResourceDatabasePopulator(schemaResource);
        schemaPopulator.execute(dataSource);

        ClassPathResource dataResource = new ClassPathResource(String.format("db/%s/data.sql", dbName));
        ResourceDatabasePopulator dataPopulator = new ResourceDatabasePopulator(dataResource);
        dataPopulator.execute(dataSource);
    }

}
