package dd.projects.DDShop.DTOs;

import dd.projects.DDShop.enitities.AssignedValue;
import dd.projects.DDShop.enitities.AttributeValue;
import dd.projects.DDShop.enitities.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@AllArgsConstructor
public class ProductAttributeCreateDTO {

    private String Name;

}
