package dd.projects.DDShop.enitities;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "user_id")
    @RestResource(path = "cartUser", rel="user")
    private User user;
    private int totalPrice;
    @OneToMany(mappedBy = "cart")
    private List<CartEntry> cartEntries;
    @OneToOne(mappedBy = "cartOrder")
    private Orders order;
}
