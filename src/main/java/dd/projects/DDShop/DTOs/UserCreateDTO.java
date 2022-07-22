package dd.projects.DDShop.DTOs;

import dd.projects.DDShop.enitities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class UserCreateDTO {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private AddressDTO defaultDeliveryAddress;

    private AddressDTO defaultBillingAddress;


}
