package by.application.controllers;

import by.application.dao.PassengersDAO;
import by.application.dao.TruckingDAO;
import by.application.dao.WagonsDAO;
import by.application.dao.WorkSafetyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;


@Controller
@RequestMapping("/Chart")
public class PromoController {
    private final PassengersDAO passengersDAO;
    private final TruckingDAO truckingDAO;
    private final WorkSafetyDAO workSafetyDAO;
    private final WagonsDAO wagonsDAO;
    @Autowired
    public PromoController(PassengersDAO passengersDAO, TruckingDAO truckingDAO, WorkSafetyDAO workSafetyDAO, WagonsDAO wagonsDAO) {
        this.passengersDAO = passengersDAO;
        this.truckingDAO = truckingDAO;
        this.workSafetyDAO = workSafetyDAO;
        this.wagonsDAO = wagonsDAO;
    }

    @GetMapping()
    public String barGraph(Model model) {
        /**------------------------------------------------------------------------------ Work Safety */
        Map<String, Integer> surveyMap = new LinkedHashMap<>();
        Map<String, Integer> surveyMap1 = new LinkedHashMap<>();
        Map<String, Integer> surveyMap2 = new LinkedHashMap<>();
        for (int i = 0; i <workSafetyDAO.indexWorkSafety().size()+1; i++) {
            if(workSafetyDAO.showWorkSafety(i) != null){
                surveyMap.put(workSafetyDAO.showWorkSafety(i).getCurrentDate(),workSafetyDAO.showWorkSafety(i).getTotal());
                surveyMap1.put(workSafetyDAO.showWorkSafety(i).getCurrentDate(),workSafetyDAO.showWorkSafety(i).getHeavy());
                surveyMap2.put(workSafetyDAO.showWorkSafety(i).getCurrentDate(),workSafetyDAO.showWorkSafety(i).getDeadly());
            }
        }
        model.addAttribute("surveyMap", surveyMap);
        model.addAttribute("surveyMap1", surveyMap1);
        model.addAttribute("surveyMap2", surveyMap2);
        /**--------------------------------------------------------------------------------- Trucking */
        Map<String, Integer> truckingMap = new LinkedHashMap<>();
        for (int i = 0; i < truckingDAO.indexTrucking().size()+1; i++) {
            if(truckingDAO.showTrucking(i) != null){
                truckingMap.put(truckingDAO.showTrucking(i).getCurrentDate(), truckingDAO.showTrucking(i).getCargoWeight());
            }
        }
        model.addAttribute("trucking", truckingMap);
        /**--------------------------------------------------------------------------------- Passenger turnover */
        Map<String, Integer> passengersMap = new LinkedHashMap<>();
        for (int i = 1; i < passengersDAO.indexPassengers().size()+1; i++) {
            if(passengersDAO.showPassengers(i) != null){
                passengersMap.put(passengersDAO.showPassengers(i).getCurrentDate(), passengersDAO.showPassengers(i).getCargoHumans());
            }
        }
        model.addAttribute("passengers", passengersMap);
        /**--------------------------------------------------------------------------------- Wagons */
        Map<String, Integer> wagonsMap = new LinkedHashMap<>();
        for (int i = 1; i < wagonsDAO.indexWagons().size()+1; i++) {
            if(wagonsDAO.showWagons(i) != null){
               wagonsMap.put(wagonsDAO.showWagons(i).getCurrentDate(),wagonsDAO.showWagons(i).getDefectionCars());
            }
        }
        model.addAttribute("wagons", wagonsMap);

        return "promo/barChart";
    }

    @GetMapping("/pieChart")
    public String pieChart(Model model) {
        model.addAttribute("pass", 50);
        model.addAttribute("fail", 50);
        return "promo/pieChart";
    }

}
