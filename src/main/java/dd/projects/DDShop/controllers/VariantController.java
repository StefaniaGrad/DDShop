package dd.projects.DDShop.controllers;

import dd.projects.DDShop.DTOs.*;
import dd.projects.DDShop.mapperss.VariantMapperImpl;
import dd.projects.DDShop.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variant")
public class VariantController {

    @Autowired
    private VariantService variantService;

    @Autowired
    private VariantMapperImpl variantMapper;

    @PostMapping("/productId={productId}")
    public VariantCreateDTO create(@PathVariable(value = "productId") int productId,
                                   @RequestBody VariantCreateDTO variantCreateDTO) {

        return variantService.createVariant(productId, variantCreateDTO, variantCreateDTO.getAssignedValuesIds());

    }

    @GetMapping
    @ResponseBody
    List<VariantGetDTO> getAllVariants(){
        return variantService.listAllVariants();
    }

    @PutMapping
    @ResponseBody
    public VariantGetDTO update(@RequestBody VariantGetDTO variantGetDTO){
        return variantService.updateVariant(variantGetDTO);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        variantService.deleteVariantById(id);
    }


}
