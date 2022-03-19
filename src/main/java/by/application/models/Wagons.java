package by.application.models;

import javax.validation.constraints.Min;

public class Wagons {
    private int id;
    private String currentDate;
    @Min(value = 0,message = "the input data can only be positive")
    private int defectionCars;

    public Wagons(){}

    public Wagons(int id, String currentDate, int defectionCars) {
        this.id = id;
        this.currentDate = currentDate;
        this.defectionCars = defectionCars;
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

    public int getDefectionCars() {
        return defectionCars;
    }

    public void setDefectionCars(int defectionCars) {
        this.defectionCars = defectionCars;
    }
}
