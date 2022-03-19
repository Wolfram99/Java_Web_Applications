package by.application.controllers;

import by.application.dao.PassengersDAO;
import by.application.models.PassengerTurnover;
import by.application.models.Trucking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengersDAO passengersDAO;
    @Autowired
    public PassengerController(PassengersDAO passengersDAO) {
        this.passengersDAO = passengersDAO;
    }

    @GetMapping("/createPassengers")
    public String newPassenger(@ModelAttribute("passenger")PassengerTurnover passengerTurnover){
        return "workSafety/createPassengers";
    }

    @PostMapping()
    public String createTrucking(@ModelAttribute("passenger")@Valid PassengerTurnover passengerTurnover, BindingResult bindingResult){
        if(bindingResult.hasErrors()){return "workSafety/createPassengers";}
        passengersDAO.createPassengers(passengerTurnover);
        return "redirect:/Chart";
    }
}
