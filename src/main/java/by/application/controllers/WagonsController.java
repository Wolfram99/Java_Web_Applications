package by.application.controllers;

import by.application.dao.WagonsDAO;
import by.application.models.Wagons;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/wagons")
public class WagonsController {

    private final WagonsDAO wagonsDAO;

    public WagonsController(WagonsDAO wagonsDAO) {
        this.wagonsDAO = wagonsDAO;
    }

    @GetMapping("/createWagons")
    public String newWagons(@ModelAttribute("wagons")Wagons wagons){
        return "workSafety/createWagons";
    }

    @PostMapping()
    public String createWag(@ModelAttribute("wagons")@Valid Wagons wagons, BindingResult bindingResult){
        if(bindingResult.hasErrors()){return "workSafety/createWagons";}
        wagonsDAO.createWagons(wagons);
        return "redirect:/Chart";
    }

}
