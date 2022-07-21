package dd.projects.DDShop.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreateDTO {
    private String name;

    private String description;
}
