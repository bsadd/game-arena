package com.buetian.gamearena.dao;

import com.buetian.gamearena.model.Country;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.FieldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
@Scope("singleton")
public class HelloWorldDao {
    Jdbi jdbi;

    public HelloWorldDao(@Autowired DataSource dataSource) {
        this.jdbi = Jdbi.create(dataSource);
    }

    public List<Country> getCountryList() {
        return jdbi.withHandle(handle -> handle.createQuery("select * from coreapp.Country")
                .map(FieldMapper.of(Country.class))
                .list());
    }

}
