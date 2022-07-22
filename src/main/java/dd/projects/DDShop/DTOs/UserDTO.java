package dd.projects.DDShop.DTOs;

import dd.projects.DDShop.enitities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class UserDTO {

    private int id;
    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private AddressDTO defaultDeliveryAddress;

    private AddressDTO defaultBillingAddress;

    private List<Order> orders;
}
