package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.OrderDTO;
import dd.projects.DDShop.enitities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface OrderMapper {

    Order OrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO OrderToOrderDTO(Order order);
}
