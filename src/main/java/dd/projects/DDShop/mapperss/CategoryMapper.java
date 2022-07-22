package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.CategoryCreateDTO;
import dd.projects.DDShop.DTOs.CategoryGetDTO;
import dd.projects.DDShop.enitities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface CategoryMapper {
    Category CategoryCreateDTOToCategory(CategoryCreateDTO categoryCreateDTO);
    CategoryCreateDTO CategoryToCategoryCreateDTO(Category category);
    Category CategoryGetDTOToCategory(CategoryGetDTO categoryGetDTO);
    CategoryGetDTO CategoryToCategoryGetDTO(Category category);
}
