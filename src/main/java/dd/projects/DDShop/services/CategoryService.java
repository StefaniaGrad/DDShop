package dd.projects.DDShop.services;

import dd.projects.DDShop.enitities.Category;
import dd.projects.DDShop.enitities.User;
import dd.projects.DDShop.repositories.CategoryRepository;
import dd.projects.DDShop.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category){ return categoryRepository.save(category);}

    public List<Category> getCategories(){ return categoryRepository.findAll();}

    public Category updateCategory(Category category) { return categoryRepository.save(category);}

    public void deleteCategoryById(int id) { categoryRepository.deleteById(id);}

}
