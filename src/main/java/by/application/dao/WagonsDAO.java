package by.application.dao;

import by.application.models.Trucking;
import by.application.models.Wagons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WagonsDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public WagonsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wagons> indexWagons(){
        return jdbcTemplate.query("SELECT * FROM Wagons", new BeanPropertyRowMapper<>(Wagons.class));
    }

    public Wagons showWagons(int id){
        return jdbcTemplate.query("SELECT * FROM Wagons WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Wagons.class)).stream().findAny().orElse(null);
    }

    public void createWagons( Wagons wagons){
        jdbcTemplate.update("INSERT INTO Wagons VALUES (default,current_date,?)",wagons.getDefectionCars());
    }
}
