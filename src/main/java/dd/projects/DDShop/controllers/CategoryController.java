package dd.projects.DDShop.controllers;

import dd.projects.DDShop.DTOs.CategoryCreateDTO;
import dd.projects.DDShop.DTOs.CategoryGetDTO;
import dd.projects.DDShop.DTOs.SubcategoryCreateDTO;
import dd.projects.DDShop.enitities.Subcategory;
import dd.projects.DDShop.repositories.SubcategoryRepository;
import dd.projects.DDShop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    SubcategoryRepository subcategoryRepository;


    @PostMapping
    CategoryCreateDTO create(@RequestBody CategoryCreateDTO category){

       return categoryService.createCategory(category);
    }

    @GetMapping
    @ResponseBody
    List<CategoryGetDTO> read(){
        return categoryService.getCategories();
    }


    @GetMapping("/{id}")
    @ResponseBody
    CategoryGetDTO read2(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }


    @PutMapping
    //@ResponseBody
    public CategoryGetDTO update(@RequestBody CategoryGetDTO category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
    }




}
