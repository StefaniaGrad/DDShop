package dd.projects.DDShop.enitities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
public class Sel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="attribute_id")
    private ProductAttribute productAttribute;

    @ManyToOne
    @JoinColumn(name="value_id")
    private AttributeValue attributeValue;

    @ManyToMany(mappedBy = "sels")
    private List<Variant> variants;
}
