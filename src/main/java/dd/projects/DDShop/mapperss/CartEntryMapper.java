package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.CartEntryDTO;
import dd.projects.DDShop.enitities.CartEntry;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface CartEntryMapper {
    CartEntry CartEntryDTOToCartEntry(CartEntryDTO cartEntryDTO);
    CartEntryDTO CartEntryToCartEntryDTO(CartEntry cartEntry);

}

