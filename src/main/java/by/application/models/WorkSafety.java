package by.application.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

public class WorkSafety {
    private int id;
    private String currentDate;

    @Min(value = 0,message = "the input data can only be positive")
    private int total;
    @Min(value = 0,message = "the input data can only be positive")
    private int heavy;
    @Min(value = 0,message = "the input data can only be positive")
    private int deadly;

    public WorkSafety(){}

    public WorkSafety(int id, String currentDate, int total, int heavy, int deadly) {
        this.id = id;
        this.currentDate = currentDate;
        this.total = total;
        this.heavy = heavy;
        this.deadly = deadly;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHeavy() {
        return heavy;
    }

    public void setHeavy(int heavy) {
        this.heavy = heavy;
    }

    public int getDeadly() {
        return deadly;
    }

    public void setDeadly(int deadly) {
        this.deadly = deadly;
    }
}
