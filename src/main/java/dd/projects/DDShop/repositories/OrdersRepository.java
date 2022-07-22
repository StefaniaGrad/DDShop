package dd.projects.DDShop.repositories;

import dd.projects.DDShop.enitities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer> {
}
