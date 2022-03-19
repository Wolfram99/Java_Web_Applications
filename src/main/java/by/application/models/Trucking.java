package by.application.models;

import javax.validation.constraints.Min;

public class Trucking {
    private int id;
    private String  currentDate;
    @Min(value = 0,message = "the input data can only be positive")
    private int cargoWeight;

    public Trucking(){}

    public Trucking(int id, String currentDate, int cargoWeight) {
        this.id = id;
        this.currentDate = currentDate;
        this.cargoWeight = cargoWeight;
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

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
}
