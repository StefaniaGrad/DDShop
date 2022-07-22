package dd.projects.DDShop.controllers;

import dd.projects.DDShop.DTOs.*;
import dd.projects.DDShop.enitities.ProductAttribute;
import dd.projects.DDShop.services.ProductAttributeService;
import dd.projects.DDShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-attribute")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;


    @PostMapping
    ProductAttributeCreateDTO create(@RequestBody ProductAttributeCreateDTO productAttributeCreateDTO) {
        return productAttributeService.create(productAttributeCreateDTO);
    }

    @GetMapping
    @ResponseBody
    List<ProductAttributeGetDTO> read(){
        return productAttributeService.getAllProductAttributes();
    }


    @PutMapping
    @ResponseBody
    public ProductAttributeGetDTO update(@RequestBody ProductAttributeGetDTO productAttributeGetDTO){
        return productAttributeService.update(productAttributeGetDTO);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        productAttributeService.deleteById(id);
    }


    @GetMapping("/{id}")
    @ResponseBody
    ProductAttributeGetDTO getAttribuiteById(@PathVariable Integer id){
        return productAttributeService.findById(id);
    }


}
