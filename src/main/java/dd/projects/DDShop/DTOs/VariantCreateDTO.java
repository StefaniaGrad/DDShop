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
public class VariantCreateDTO {

    private int quantity;

    private int price;

    private List<Integer> assignedValuesIds;
}
