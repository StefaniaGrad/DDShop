package dd.projects.DDShop.enitities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private int price;

    private int availableQuantity;

    @ManyToMany(mappedBy = "products")
    private List<Category> category;

//    @OneToOne
//    @JoinColumn(name = "attribute_id")
//    @RestResource(path = "productAttribute", rel="attribute")
    @OneToOne(cascade = CascadeType.ALL)
    private ProductAttribute attribute;

    @OneToMany(mappedBy = "variant")
    private List<CartEntry> cartEntryList;

    @OneToMany(mappedBy = "product")
    private List<Variant> variants;


}
