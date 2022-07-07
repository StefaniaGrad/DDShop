package dd.projects.DDShop.enitities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int paymentType;

    private int totalPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @OneToOne
//    @JoinColumn(name = "cart_id")
//    @RestResource(path = "libraryAddress", rel="address")
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @OneToOne(cascade = CascadeType.ALL)
    private Address deliveryAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private Address billingAddress;


}
