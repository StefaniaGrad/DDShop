package dd.projects.DDShop.DTOs;

import dd.projects.DDShop.enitities.AssignedValue;
import dd.projects.DDShop.enitities.ProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
public class AttributeValueCreateDTO {

    private String value;

}
