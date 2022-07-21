package dd.projects.DDShop.DTOs;

import dd.projects.DDShop.enitities.Address;
import dd.projects.DDShop.enitities.Cart;
import dd.projects.DDShop.enitities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
public class OrderDTO {

    private int id;

    private int paymentType;

    private int totalPrice;

    private UserDTO user;

    private CartDTO cart;

    private AddressDTO deliveryAddress;

    private AddressDTO billingAddress;

}
