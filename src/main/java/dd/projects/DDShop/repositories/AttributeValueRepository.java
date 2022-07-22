package dd.projects.DDShop.repositories;

import dd.projects.DDShop.enitities.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue, Integer> {
    List<AttributeValue> findByProductAttributeId(int id);
}
