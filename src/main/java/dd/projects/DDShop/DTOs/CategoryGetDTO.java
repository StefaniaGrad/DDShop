package dd.projects.DDShop.DTOs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dd.projects.DDShop.enitities.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
public class CategoryGetDTO {
    private int id;

    private String name;
    private List<SubcategoryGetDTO> subcategories;
}
