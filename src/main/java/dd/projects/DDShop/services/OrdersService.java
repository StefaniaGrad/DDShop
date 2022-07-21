package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.OrderDTO;
import dd.projects.DDShop.enitities.Order;
import dd.projects.DDShop.mapperss.OrderMapperImpl;
import dd.projects.DDShop.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    @Autowired
    private final OrdersRepository ordersRepository;

    @Autowired
    private OrderMapperImpl orderMapper;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public OrdersRepository getOrderRepository(){ return ordersRepository;}

    public OrderDTO createOrder(OrderDTO orderDTO)
    {
        Order order=orderMapper.OrderDTOToOrder(orderDTO);
        return orderMapper.OrderToOrderDTO(ordersRepository.save(order));
    }

    public List<OrderDTO> getALLOrders(){

        return ordersRepository.findAll()
                .stream().map(order -> orderMapper.OrderToOrderDTO(order)).collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByUserId(int id){

        return ordersRepository.findAllOrderByUserId(id)
                .stream().map(order -> orderMapper.OrderToOrderDTO(order)).collect(Collectors.toList());
    }

    public OrderDTO getOrderById(int id){
        return orderMapper.OrderToOrderDTO(ordersRepository.findById(id).get());
    }

    public List<OrderDTO> getOrdersByStatus(int status){

        return ordersRepository.findAllOrderByStatus(status)
                .stream().map(order -> orderMapper.OrderToOrderDTO(order)).collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByUserAndStatus( int id, int status){

        return ordersRepository.findAllOrderByUserId(id)
                .stream().filter(order -> order.getStatus()==status).map(order -> orderMapper.OrderToOrderDTO(order)).collect(Collectors.toList());
    }


    public OrderDTO updateOrderStatus(int id,int status){
        Order order=ordersRepository.findById(id).get();
        order.setStatus(status );
        return orderMapper.OrderToOrderDTO(ordersRepository.save(order));
    }

    public void deleteOrderById(int id) { ordersRepository.deleteById(id);}
}
