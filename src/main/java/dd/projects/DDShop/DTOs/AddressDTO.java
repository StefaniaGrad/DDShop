package dd.projects.DDShop.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class AddressDTO {
    private String streetLine;

    private int postalCode;

    private String city;

    private String county;

    private String country;
}
