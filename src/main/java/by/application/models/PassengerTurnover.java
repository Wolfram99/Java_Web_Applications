package by.application.models;

import javax.validation.constraints.Min;

public class PassengerTurnover {
    private int id;
    private String currentDate;
    @Min(value = 0,message = "the input data can only be positive")
    private int cargoHumans;

    public PassengerTurnover(){};

    public PassengerTurnover(int id, String currentDate, int cargoHumans) {
        this.id = id;
        this.currentDate = currentDate;
        this.cargoHumans = cargoHumans;
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

    public int getCargoHumans() {
        return cargoHumans;
    }

    public void setCargoHumans(int cargoHumans) {
        this.cargoHumans = cargoHumans;
    }
}
