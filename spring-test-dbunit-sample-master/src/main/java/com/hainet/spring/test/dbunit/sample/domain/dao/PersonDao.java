package com.hainet.spring.test.dbunit.sample.domain.dao;

import com.hainet.spring.test.dbunit.sample.domain.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public int insert(final Person person) {
        return jdbcTemplate.update("INSERT INTO person (name) VALUES (?)", person.getName());
    }

    public int update(final Person person) {
        return jdbcTemplate.update("UPDATE person SET name = ? WHERE id = ?", person.getName(), person.getId());
    }

    public int delete(final Person person) {
        return jdbcTemplate.update("DELETE FROM person WHERE id = ?", person.getId());
    }
}
