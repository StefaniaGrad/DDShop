package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.SubcategoryCreateDTO;
import dd.projects.DDShop.DTOs.SubcategoryGetDTO;
import dd.projects.DDShop.enitities.Subcategory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface SubcategoryMapper {
    Subcategory SubcategoryCreateDTOTOSubcategory(SubcategoryCreateDTO subcategoryCreateDTO);
    SubcategoryCreateDTO SubcategoryToSubcategoryCreateDTO(Subcategory subcategory);
    SubcategoryGetDTO SubcategoryToSubcategoryGetDTO(Subcategory subcategory);
    Subcategory SubcategoryGetDTOToSubcategory(SubcategoryGetDTO subcategoryGetDTO);
}
