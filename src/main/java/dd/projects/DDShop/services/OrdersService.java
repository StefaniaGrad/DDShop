package dd.projects.DDShop.services;

import dd.projects.DDShop.enitities.Orders;
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

    public Orders createOrder(Orders orders)
    {
        return ordersRepository.save(orders);
    }

    public List<Orders> getOrders(){
        return ordersRepository.findAll();
    }

    public  Orders updateOrder(Orders orders){
        return ordersRepository.save(orders);
    }

    public void deleteOrderById(int id) { ordersRepository.deleteById(id);}
}
