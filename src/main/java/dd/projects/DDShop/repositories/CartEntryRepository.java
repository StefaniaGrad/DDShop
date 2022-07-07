package dd.projects.DDShop.repositories;

import dd.projects.DDShop.enitities.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartEntryRepository extends JpaRepository<CartEntry, Integer> {
}
