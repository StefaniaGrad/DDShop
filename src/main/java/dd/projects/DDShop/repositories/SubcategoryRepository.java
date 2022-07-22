package dd.projects.DDShop.repositories;


import dd.projects.DDShop.enitities.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository  extends JpaRepository<Subcategory, Integer> {
    List<Subcategory> findByCategoryId(int id);
}
