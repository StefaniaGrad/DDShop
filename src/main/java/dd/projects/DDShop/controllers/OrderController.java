package dd.projects.DDShop.controllers;

import dd.projects.DDShop.DTOs.OrderDTO;
import dd.projects.DDShop.DTOs.UserCreateDTO;
import dd.projects.DDShop.DTOs.UserDTO;
import dd.projects.DDShop.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private final OrdersService ordersService;

    public OrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    @ResponseBody
    List<OrderDTO> getAllOrders(){
        return ordersService.getALLOrders();
    }

    @GetMapping("/user={id}")
    @ResponseBody
    List<OrderDTO> getOrdersByUserId(@PathVariable Integer id){
        return ordersService.getOrdersByUserId(id);
    }

    @GetMapping("/user={id}/status={status}")
    @ResponseBody
    List<OrderDTO> getOrdersByUserIdWithStatus(@PathVariable Integer id,@PathVariable Integer status){
        return ordersService.getOrdersByUserAndStatus(id,status);
    }

    @GetMapping("/status={status}")
    @ResponseBody
    List<OrderDTO> getOrdersWithStatus(@PathVariable Integer status){
        return ordersService.getOrdersByStatus(status);
    }

    @PutMapping("/{id}")
    @ResponseBody
    OrderDTO update(@PathVariable Integer id, @RequestBody Integer status){
        return ordersService.updateOrderStatus(id,status);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        ordersService.deleteOrderById(id);
    }



}
