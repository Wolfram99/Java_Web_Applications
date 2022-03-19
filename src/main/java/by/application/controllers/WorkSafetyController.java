package by.application.controllers;

import by.application.dao.TruckingDAO;
import by.application.dao.WorkSafetyDAO;
import by.application.models.Trucking;
import by.application.models.WorkSafety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/work_safety")
public class WorkSafetyController {

    private final WorkSafetyDAO workSafetyDAO;
    @Autowired
    public WorkSafetyController( WorkSafetyDAO workSafetyDAO) {
            this.workSafetyDAO = workSafetyDAO;
    }

    @GetMapping()
    public String indexWorkSafety(Model model){
        model.addAttribute("workSafety",workSafetyDAO.indexWorkSafety());
        return "workSafety/index";
    }

    @GetMapping("/{id}")
    public String showWorkSafety(@PathVariable("id") int id,Model model){
            model.addAttribute("workSafety",workSafetyDAO.showWorkSafety(id));
        return "workSafety/show";
    }

    @GetMapping("/create")
    public String newWorkSafety(@ModelAttribute("workSafety")WorkSafety workSafety){
        return "workSafety/create";
    }

    @PostMapping()
    public String create(@ModelAttribute("workSafety")@Valid WorkSafety workSafety, BindingResult bindingResult){
        if(bindingResult.hasErrors()){return "workSafety/create";}
        workSafetyDAO.createWorkSafety(workSafety);
        return "redirect:/Chart";
    }

    @GetMapping("/{id}/update")
    public String editWorkSafety( Model model,@PathVariable("id")int id){
        model.addAttribute("workSafety",workSafetyDAO.showWorkSafety(id));
        return "workSafety/update";
    }

    @PatchMapping("/{id}")
    public String updateWorkSafety(@ModelAttribute ("workSafety")@Valid WorkSafety workSafety,BindingResult bindingResult,
                                   @PathVariable("id")int id){
        if (bindingResult.hasErrors())
        {return "workSafety/update";
        }else {
            workSafetyDAO.updateWorkSafety(id, workSafety);
            return "redirect:/work_safety";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteWorkSafety(@PathVariable("id")int id){
        workSafetyDAO.deleteWorkSafety(id);
        return "redirect:/work_safety";
    }
}
