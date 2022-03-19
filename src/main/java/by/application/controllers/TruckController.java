package by.application.controllers;

import by.application.dao.TruckingDAO;
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
@RequestMapping("/truck")
public class TruckController {
    private final TruckingDAO truckingDAO;
    @Autowired
    public TruckController(TruckingDAO truckingDAO) {
        this.truckingDAO = truckingDAO;
    }

    @GetMapping("/createTruck")
    public String newTrucking(@ModelAttribute("truck") Trucking trucking){
        return "workSafety/createTruck";
    }

    @PostMapping()
    public String createTrucking(@ModelAttribute("truck")@Valid Trucking trucking, BindingResult bindingResult){
        if(bindingResult.hasErrors()){return "workSafety/createTruck";}
        truckingDAO.createTrucking(trucking);
        return "redirect:/Chart";
    }
}
