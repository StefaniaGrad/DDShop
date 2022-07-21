package dd.projects.DDShop.enitities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class AssignedValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="product_attribute_id")
    private ProductAttribute productAttribute;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="attribute_value_id")
    private AttributeValue attributeValue;

    @JsonBackReference
    @ManyToMany(mappedBy = "assignedValues")
    private List<Variant> variants;

    public void assignVariant(Variant variant){
        this.variants.add(variant);
    }

    public AssignedValue() {
        this.variants=new ArrayList<Variant>();
    }

    public AssignedValue(ProductAttribute productAttribute, AttributeValue attributeValue) {
        this.productAttribute = productAttribute;
        this.attributeValue = attributeValue;
        this.variants=new ArrayList<Variant>();
    }

    public AssignedValue(int id, ProductAttribute productAttribute, AttributeValue attributeValue) {
        this.id = id;
        this.productAttribute = productAttribute;
        this.attributeValue = attributeValue;
        this.variants=new ArrayList<Variant>();
    }
}
