package dd.projects.DDShop.repositories;

import dd.projects.DDShop.enitities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer> {
    public List<Order> findAllOrderByUserId(int id);
    public List<Order> findAllOrderByStatus(int status);
}
