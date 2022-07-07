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

    @OneToOne(cascade = CascadeType.ALL)
    private Address defaultDeliveryAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private Address defaultBillingAddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Orders> orders;

}
