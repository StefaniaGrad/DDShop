package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.ProductAttributeCreateDTO;
import dd.projects.DDShop.DTOs.ProductAttributeGetDTO;
import dd.projects.DDShop.enitities.ProductAttribute;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ProductAttributeMapper {
    ProductAttribute ProductAttributeCreateDTOToProductAttribute(ProductAttributeCreateDTO productAttributeCreateDTO);
    ProductAttributeCreateDTO ProductAttributeToProductAttributeCreateDTO(ProductAttribute productAttribute);
    ProductAttribute ProductAttributeGetDTOToProductAttribute(ProductAttributeGetDTO productAttributeGetDTO);
    ProductAttributeGetDTO ProductAttributeToProductAttributeGetDTO(ProductAttribute productAttribute);
}
