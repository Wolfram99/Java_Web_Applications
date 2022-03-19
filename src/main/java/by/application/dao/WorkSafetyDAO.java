package by.application.dao;

import by.application.models.WorkSafety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class WorkSafetyDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public WorkSafetyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<WorkSafety> indexWorkSafety(){
        return jdbcTemplate.query("SELECT * FROM WorkSafety", new BeanPropertyRowMapper<>(WorkSafety.class));
    }

    public WorkSafety showWorkSafety(int id){
        return jdbcTemplate.query("SELECT * FROM WorkSafety WHERE id=?", new Object[] {id}, new BeanPropertyRowMapper<>(WorkSafety.class))
                .stream().findAny().orElse(null);
    }

    public void createWorkSafety( WorkSafety workSafety){
        jdbcTemplate.update("INSERT INTO WorkSafety VALUES (default,current_date,?,?,?)",workSafety.getTotal(),workSafety.getHeavy(),workSafety.getDeadly());
    }

    public void updateWorkSafety(int id, WorkSafety updateWorkSafety){
        jdbcTemplate.update("UPDATE WorkSafety SET total=?,heavy=?,deadly=? WHERE id=?",updateWorkSafety.getTotal(),updateWorkSafety.getHeavy(),updateWorkSafety.getDeadly(),id);
    }

    public void deleteWorkSafety(int id){
        jdbcTemplate.update("DELETE FROM WorkSafety WHERE id=?",id);
    }

    public List<String> countRowFromTable(){
        return jdbcTemplate.query("SELECT COUNT(1) FROM worksafety", new BeanPropertyRowMapper<>(String.class));
    }

}
