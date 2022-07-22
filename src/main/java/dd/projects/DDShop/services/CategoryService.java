package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.CategoryCreateDTO;
import dd.projects.DDShop.DTOs.CategoryGetDTO;
import dd.projects.DDShop.enitities.Category;
import dd.projects.DDShop.mapperss.CategoryMapperImpl;
import dd.projects.DDShop.repositories.CategoryRepository;
import dd.projects.DDShop.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryMapperImpl categoryMapper;



    public CategoryService(CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    public CategoryCreateDTO createCategory(CategoryCreateDTO categoryDTO){
        Category category=categoryMapper.CategoryCreateDTOToCategory(categoryDTO);
        return categoryMapper.CategoryToCategoryCreateDTO(categoryRepository.save(category));}


    public List<CategoryGetDTO> getCategories(){
        return categoryRepository.findAll().stream().map(category -> categoryMapper.CategoryToCategoryGetDTO(category)).collect(Collectors.toList());
    }

    public CategoryGetDTO updateCategory(CategoryGetDTO categoryDTO) {
        Category category=categoryMapper.CategoryGetDTOToCategory(categoryDTO);
        return categoryMapper.CategoryToCategoryGetDTO(categoryRepository.save(category));}

    public void deleteCategoryById(int id) { categoryRepository.deleteById(id);}

    public CategoryGetDTO getCategoryById(int id)
    {
        return categoryMapper.CategoryToCategoryGetDTO(categoryRepository.findById(id).get());
    }

}
