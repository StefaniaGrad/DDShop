package dd.projects.DDShop.DTOs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dd.projects.DDShop.enitities.AssignedValue;
import dd.projects.DDShop.enitities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
public class VariantGetDTO {

    private int id;


    private int quantity;

    private int price;

    private ProductGetDTO product;

    private List<AssignedValueGetDTO> assignedValues;
}
