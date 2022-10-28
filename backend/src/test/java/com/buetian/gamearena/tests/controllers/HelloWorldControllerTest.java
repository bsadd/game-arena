package com.buetian.gamearena.tests.controllers;

import com.buetian.gamearena.controllers.HelloWorldController;
import com.buetian.gamearena.io.CountryListResponse;
import com.buetian.gamearena.tests.util.DBHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloWorldControllerTest extends DBHelper {

    @Autowired
    private HelloWorldController helloWorldController;

    @Test
    public void contextLoads() {
        assertThat(helloWorldController).isNotNull();
    }

    @Test
    public void testHelloWorld() {
        assertThat(helloWorldController.world("DiamondKing")).isEqualTo("Hello, DiamondKing!");
    }

    @Test
    public void testCountries() {
        resetDbCoreapp();

        CountryListResponse countryListResponse = helloWorldController.listCountries();
        assertThat(countryListResponse).isNotNull();
        assertThat(countryListResponse.getCountries()).isNotNull();
        assertThat(countryListResponse.getCountries().size()).isEqualTo(2);
    }

}
