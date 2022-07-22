package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.AttributeValueCreateDTO;
import dd.projects.DDShop.DTOs.AttributeValueGetDTO;
import dd.projects.DDShop.enitities.AttributeValue;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface AttributeValueMapper {
    AttributeValue AttributeValueCreateDTOToAttributeValue(AttributeValueCreateDTO attributeValueCreateDTO);
    AttributeValueCreateDTO AttributeValueToAttributeValueCreateDTO(AttributeValue attributeValue);
    AttributeValue AttributeValueGetDTOToAttributeValue(AttributeValueGetDTO attributeValueGetDTO);
    AttributeValueGetDTO AttributeValueToAttributeValueGetDTO(AttributeValue attributeValue);
}
