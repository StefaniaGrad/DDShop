package dd.projects.DDShop.enitities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    //@OneToOne(cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "default_delivery_address_id")
    @RestResource(path = "defaultDeliveryAddress", rel="address")
    private Address defaultDeliveryAddress;

   // @OneToOne(cascade = CascadeType.ALL)
   @OneToOne
   @JoinColumn(name = "default_billing_address_id")
   @RestResource(path = "defaultBillingAddress", rel="address")
    private Address defaultBillingAddress;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

}
