package dd.projects.DDShop.services;

import dd.projects.DDShop.enitities.Order;
import dd.projects.DDShop.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public OrdersRepository getOrderRepository(){ return ordersRepository;}

    public Order createOrder(Order order)
    {
        return ordersRepository.save(order);
    }

    public List<Order> getOrders(){
        return ordersRepository.findAll();
    }

    public Order updateOrder(Order order){
        return ordersRepository.save(order);
    }

    public void deleteOrderById(int id) { ordersRepository.deleteById(id);}
}
