package dd.projects.DDShop.repositories;

import dd.projects.DDShop.enitities.Address;
import dd.projects.DDShop.enitities.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Integer> {
    List<Variant> findByProductId(int id);
}