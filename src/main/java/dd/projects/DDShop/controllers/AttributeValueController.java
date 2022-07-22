package dd.projects.DDShop.controllers;

import dd.projects.DDShop.DTOs.AttributeValueCreateDTO;
import dd.projects.DDShop.DTOs.AttributeValueGetDTO;
import dd.projects.DDShop.DTOs.SubcategoryCreateDTO;
import dd.projects.DDShop.DTOs.SubcategoryGetDTO;
import dd.projects.DDShop.services.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attribute-value")
public class AttributeValueController {

    @Autowired
    private AttributeValueService attributeValueService;

    @GetMapping("/product-Attribute={id}")
    @ResponseBody
    List<AttributeValueGetDTO> valuesForAttribtue(@PathVariable Integer id){
        return attributeValueService.attributeValueGetDTOList(id);
    }

    @PostMapping("/product-Attribute={id}")
    public AttributeValueGetDTO create(@PathVariable int id,
                                       @RequestBody AttributeValueCreateDTO attributeValueCreateDTO) {

        return   attributeValueService.create(id,attributeValueCreateDTO);

    }

    @PutMapping
    @ResponseBody
    public AttributeValueGetDTO update(@RequestBody AttributeValueGetDTO attributeValueGetDTO){
        return attributeValueService.update(attributeValueGetDTO);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        attributeValueService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AttributeValueGetDTO findAttributeById(@PathVariable Integer id){
        return attributeValueService.getAttributeById(id);
    }

}
