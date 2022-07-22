package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.ProductCreateDTO;
import dd.projects.DDShop.DTOs.ProductGetDTO;
import dd.projects.DDShop.enitities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ProductMapper {
    Product ProductCreateDTOToProduct(ProductCreateDTO productCreateDTO);
    ProductCreateDTO ProductToProductCreateDTO(Product product);
    Product ProductGetDTOToProduct(ProductGetDTO productGetDTO);
    ProductGetDTO ProductToProductGetDTO(Product product);
}
