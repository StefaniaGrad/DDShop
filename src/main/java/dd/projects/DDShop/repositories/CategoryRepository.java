package dd.projects.DDShop.repositories;

import dd.projects.DDShop.enitities.Address;
import dd.projects.DDShop.enitities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
