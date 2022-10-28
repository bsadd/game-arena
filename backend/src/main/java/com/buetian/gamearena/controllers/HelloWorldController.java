package com.buetian.gamearena.controllers;

import com.buetian.gamearena.dao.HelloWorldDao;
import com.buetian.gamearena.io.CountryListResponse;
import com.buetian.gamearena.io.HellowWorldResponse;
import com.buetian.gamearena.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloWorldController {

    @Autowired
    HelloWorldDao helloWorldDao;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public HelloWorldController() {
    }

    @GetMapping("/greeting")
    public HellowWorldResponse greeting ( @RequestParam(value = "name", defaultValue = "World") String name) {
        return new HellowWorldResponse(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/hello")
    public String world ( @RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(template, name);
    }


    @GetMapping("/countries")
    public CountryListResponse listCountries() {
        List<Country> countryList = helloWorldDao.getCountryList();
        return CountryListResponse.builder()
                .countries(countryList)
                .build();
    }
}