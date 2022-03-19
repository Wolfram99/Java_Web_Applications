package by.application.dao;

import by.application.models.Trucking;
import by.application.models.WorkSafety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TruckingDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public TruckingDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Trucking> indexTrucking(){
        return jdbcTemplate.query("SELECT * FROM trucking", new BeanPropertyRowMapper<>(Trucking.class));
    }

    public Trucking showTrucking(int id){
        return jdbcTemplate.query("SELECT * FROM trucking WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Trucking.class))
                .stream().findAny().orElse(null);
    }

    public void createTrucking( Trucking trucking){
        jdbcTemplate.update("INSERT INTO Trucking VALUES (default,current_date,?)",trucking.getCargoWeight());
    }

}
