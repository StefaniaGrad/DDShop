package dd.projects.DDShop.repositories;

import dd.projects.DDShop.enitities.AssignedValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignedValueRepository  extends JpaRepository<AssignedValue, Integer> {
}
