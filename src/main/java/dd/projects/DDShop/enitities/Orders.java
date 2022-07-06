package dd.projects.DDShop.enitities;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int paymentType;

    private int totalPrice;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @RestResource(path = "libraryAddress", rel="address")
    private Cart cartOrder;

    @OneToOne
    @JoinColumn(name = "delivery_address_id")
    @RestResource(path = "defaultDeliveryAddress", rel="address")
    private Address defaultDeliveryAddress;

    // @OneToOne(cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "billing_address_id")
    @RestResource(path = "defaultBillingAddress", rel="address")
    private Address defaultBillingAddress;


}
