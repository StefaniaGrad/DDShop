package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.AssignedValueGetDTO;
import dd.projects.DDShop.enitities.AssignedValue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface AssignedValueMapper {

    AssignedValue AssignedValueGetDTOToAssignedValue(AssignedValueGetDTO assignedValueGetDTO);

    @Mappings({
            @Mapping(target = "productAttributeName", expression = "java(assignedValue.getProductAttribute().getName())"),
            @Mapping(target = "attributeValueName", expression = "java(assignedValue.getAttributeValue().getValue())")

    })
    AssignedValueGetDTO AssignedValueToAssignedValueGetDTO(AssignedValue assignedValue);
}
