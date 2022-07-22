package dd.projects.DDShop.enitities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
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

    @OneToOne(cascade = CascadeType.ALL)
    private Address defaultDeliveryAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private Address defaultBillingAddress;

    @JsonManagedReference
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<Order> orders;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String phoneNumber, Address defaultDeliveryAddress, Address defaultBillingAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.defaultDeliveryAddress = defaultDeliveryAddress;
        this.defaultBillingAddress = defaultBillingAddress;
    }

    public User(String firstName, String lastName, String email, String phoneNumber, Address defaultDeliveryAddress, Address defaultBillingAddress, List<Order> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.defaultDeliveryAddress = defaultDeliveryAddress;
        this.defaultBillingAddress = defaultBillingAddress;
        this.orders = orders;
    }
}
