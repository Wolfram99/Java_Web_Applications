package by.application.dao;

import by.application.models.PassengerTurnover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassengersDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PassengersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PassengerTurnover showPassengers(int id){
        return jdbcTemplate.query("SELECT * FROM Passengers WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(PassengerTurnover.class)).stream().findAny().orElse(null);
    }

    public void createPassengers( PassengerTurnover passengerTurnover){
        jdbcTemplate.update("INSERT INTO Passengers VALUES (default,current_date,?)",passengerTurnover.getCargoHumans());
    }

    public List<PassengerTurnover> indexPassengers(){
        return jdbcTemplate.query("SELECT * FROM Passengers", new BeanPropertyRowMapper<>(PassengerTurnover.class));
    }
}
