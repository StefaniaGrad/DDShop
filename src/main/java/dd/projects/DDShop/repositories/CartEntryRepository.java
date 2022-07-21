package dd.projects.DDShop.repositories;

import dd.projects.DDShop.enitities.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartEntryRepository extends JpaRepository<CartEntry, Integer> {
    public List<CartEntry> findByCartId(int id);
}
