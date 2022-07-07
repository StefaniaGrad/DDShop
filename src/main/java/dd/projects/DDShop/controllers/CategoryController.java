package dd.projects.DDShop.controllers;

import dd.projects.DDShop.enitities.Category;
import dd.projects.DDShop.enitities.User;
import dd.projects.DDShop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    void create(@RequestBody Category category){
        categoryService.createCategory(category);
    }

    @GetMapping
    @ResponseBody
    List<Category> read(){
        return categoryService.getCategories();
    }

    @PutMapping
    @ResponseBody
    Category update(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
    }

}
