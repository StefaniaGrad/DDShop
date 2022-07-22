package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.CartDTO;
import dd.projects.DDShop.enitities.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface CartMapper {
    Cart CartDTOToCart(CartDTO cartDTO);
    CartDTO CartToCartDTO(Cart cart);
}
