package dd.projects.DDShop.controllers;

import dd.projects.DDShop.DTOs.AssignedValueGetDTO;
import dd.projects.DDShop.services.AssignedValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assigned-value")
public class AssignedValuesController {

    @Autowired
    private final AssignedValueService assignedValueService;

    public AssignedValuesController(AssignedValueService assignedValueService) {
        this.assignedValueService = assignedValueService;
    }


    @GetMapping
    @ResponseBody
    List<AssignedValueGetDTO> listAssignedValues(){
        return assignedValueService.getAllAssignedValues();
    }

}
