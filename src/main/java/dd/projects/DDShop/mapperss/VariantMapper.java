package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.VariantCreateDTO;
import dd.projects.DDShop.DTOs.VariantGetDTO;
import dd.projects.DDShop.enitities.Variant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface VariantMapper {
    Variant VariantCreateDTOToVariant(VariantCreateDTO variantCreateDTO);
    VariantCreateDTO VariantToVariantCreateDTO(Variant variant);
    Variant VariantGetDTOToVariant(VariantGetDTO variantGetDTO);
    VariantGetDTO VariantToVariantGetDTO(Variant variant);

}
