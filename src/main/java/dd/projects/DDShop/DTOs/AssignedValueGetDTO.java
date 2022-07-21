package dd.projects.DDShop.DTOs;

import dd.projects.DDShop.enitities.AttributeValue;
import dd.projects.DDShop.enitities.ProductAttribute;
import dd.projects.DDShop.enitities.Variant;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
public class AssignedValueGetDTO {

    private int id;

    private String productAttributeName;

    private String attributeValueName;

}
