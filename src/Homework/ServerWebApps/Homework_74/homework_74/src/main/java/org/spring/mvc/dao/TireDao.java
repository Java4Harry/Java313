package org.spring.mvc.dao;

import org.spring.mvc.entity.Tire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TireDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveTire(Tire tire) {
        String sql = "INSERT INTO tire(season, radius, width, height) VALUES(?,?,?,?)";
        int i = jdbcTemplate.update(sql, tire.getCheck(), tire.getRadius(), tire.getWidth(), tire.getHeight());
        return i;
    }
}
