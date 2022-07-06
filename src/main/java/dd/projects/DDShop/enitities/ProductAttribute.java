package dd.projects.DDShop.enitities;

import javax.persistence.*;
import java.util.List;


@Entity
public class ProductAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Name;

    @OneToOne(mappedBy = "productAttribute")
    private Product product;

    @OneToMany(mappedBy = "productAttribute")
    private List<AttributeValue> attributeValues;

}
