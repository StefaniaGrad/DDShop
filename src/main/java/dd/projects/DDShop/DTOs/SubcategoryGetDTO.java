package dd.projects.DDShop.DTOs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dd.projects.DDShop.enitities.Category;
import dd.projects.DDShop.enitities.Product;
import dd.projects.DDShop.enitities.ProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
public class SubcategoryGetDTO {

    private int id;

    private String name;

    private List<ProductGetDTO> products;

    private List<ProductAttributeGetDTO> productAttributes;

}
