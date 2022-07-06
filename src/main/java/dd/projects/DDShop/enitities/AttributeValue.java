package dd.projects.DDShop.enitities;

import javax.persistence.*;

@Entity
public class AttributeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String value;

    @ManyToOne
    @JoinColumn(name="product_attribute_id")
    private ProductAttribute productAttribute;
}
