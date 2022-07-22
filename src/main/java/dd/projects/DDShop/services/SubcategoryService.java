package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.SubcategoryCreateDTO;
import dd.projects.DDShop.DTOs.SubcategoryGetDTO;
import dd.projects.DDShop.enitities.Subcategory;
import dd.projects.DDShop.mapperss.SubcategoryMapperImpl;
import dd.projects.DDShop.repositories.CategoryRepository;
import dd.projects.DDShop.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubcategoryService {
    @Autowired
    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryMapperImpl subcategoryMapper;

    public SubcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }



    public List<SubcategoryGetDTO> getSubcategories(){
        return subcategoryRepository.findAll().stream().map(subcategory -> subcategoryMapper.SubcategoryToSubcategoryGetDTO(subcategory)).collect(Collectors.toList());
    }

    public SubcategoryGetDTO createSubcategory(int categoryId, SubcategoryCreateDTO subcategoryCreateDTO) {
        Subcategory subcategory=subcategoryMapper.SubcategoryCreateDTOTOSubcategory(subcategoryCreateDTO);
        subcategory.setCategory(categoryRepository.findById(categoryId).get());
        return subcategoryMapper.SubcategoryToSubcategoryGetDTO(subcategoryRepository.save(subcategory));
    }

    public SubcategoryGetDTO updateSubcategory(SubcategoryGetDTO subcategoryGetDTO) {
        Subcategory subcategory = subcategoryMapper.SubcategoryGetDTOToSubcategory(subcategoryGetDTO);
        return subcategoryMapper.SubcategoryToSubcategoryGetDTO(subcategoryRepository.save(subcategory));
    }

    public void deleteSubcategoryById(int id) { subcategoryRepository.deleteById(id);}

    public SubcategoryGetDTO getSubcategoryById(Integer id){
        return subcategoryMapper.SubcategoryToSubcategoryGetDTO(subcategoryRepository.findById(id).get());
    }

    public List<SubcategoryGetDTO> getSubcategoriesByCategoryId(Integer id){
        return subcategoryRepository.findByCategoryId(id).stream().map(subcategory -> subcategoryMapper.SubcategoryToSubcategoryGetDTO(subcategory)).collect(Collectors.toList());
    }
}
