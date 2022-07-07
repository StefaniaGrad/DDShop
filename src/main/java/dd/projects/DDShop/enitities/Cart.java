package dd.projects.DDShop.enitities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   /* @OneToOne
    @JoinColumn(name = "user_id")
    @RestResource(path = "cartUser", rel = "user")*/
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private int totalPrice;

    @OneToMany(mappedBy = "cart")
    private List<CartEntry> cartEntries;

}
