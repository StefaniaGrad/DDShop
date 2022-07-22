package dd.projects.DDShop.controllers;

import dd.projects.DDShop.DTOs.CategoryGetDTO;
import dd.projects.DDShop.DTOs.SubcategoryCreateDTO;
import dd.projects.DDShop.DTOs.SubcategoryGetDTO;
import dd.projects.DDShop.enitities.Subcategory;
import dd.projects.DDShop.services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategory")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping
    @ResponseBody
    List<SubcategoryGetDTO> getAllSubcategories(){
        return subcategoryService.getSubcategories();
    }

    @PostMapping("/categoryId={categoryId}")
    public SubcategoryGetDTO create(@PathVariable(value = "categoryId") int categoryId,
                                 @RequestBody SubcategoryCreateDTO subcategory) {

       return     subcategoryService.createSubcategory(categoryId, subcategory);

    }

    @GetMapping("/categoryId={categoryId}")
    @ResponseBody
    List<SubcategoryGetDTO> getSubcategoriesByCategoryId(@PathVariable Integer categoryId){
        return subcategoryService.getSubcategoriesByCategoryId(categoryId);
    }

    @PutMapping
    @ResponseBody
    public SubcategoryGetDTO update(@RequestBody SubcategoryGetDTO subcategory){
        return subcategoryService.updateSubcategory(subcategory);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
         subcategoryService.deleteSubcategoryById(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    SubcategoryGetDTO getSubcategoriesById(@PathVariable Integer id){
        return subcategoryService.getSubcategoryById(id);
    }



}
