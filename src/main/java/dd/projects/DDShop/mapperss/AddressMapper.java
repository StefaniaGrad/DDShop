package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.AddressDTO;
import dd.projects.DDShop.enitities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface AddressMapper {
    Address addressDTOToAddress(AddressDTO addressDTO);
    AddressDTO addressToAddressDTO(Address address);
}
