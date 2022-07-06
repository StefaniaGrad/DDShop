package dd.projects.DDShop.enitities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;
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

    @OneToOne
    @JoinColumn(name = "attribute_id")
    @RestResource(path = "productAttribute", rel="attribute")
    private ProductAttribute productAttribute;

    @OneToMany(mappedBy = "product")
    private List<CartEntry> cartEntryList;

    @OneToMany(mappedBy = "product")
    private List<Variant> variants;


}
