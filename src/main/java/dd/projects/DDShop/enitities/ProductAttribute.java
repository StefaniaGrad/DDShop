package dd.projects.DDShop.enitities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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

    @OneToMany(mappedBy = "productAttribute")
    private List<Sel> sels;

}
