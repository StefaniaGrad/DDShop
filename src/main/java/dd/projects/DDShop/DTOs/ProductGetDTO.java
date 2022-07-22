package dd.projects.DDShop.DTOs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dd.projects.DDShop.enitities.Subcategory;
import dd.projects.DDShop.enitities.Variant;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductGetDTO {

    private int id;

    private String name;

    private String description;

    private List<Variant> variants;
}
