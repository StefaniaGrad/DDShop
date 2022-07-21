package dd.projects.DDShop.enitities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class ProductAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "productAttribute",cascade = CascadeType.ALL)
    private List<AttributeValue> attributeValues;

    @JsonManagedReference
    @OneToMany(mappedBy = "productAttribute",cascade = CascadeType.ALL)
    private List<AssignedValue> assignedValues;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "subcat_prod_att",
            joinColumns = @JoinColumn(name = "product_attribute_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    private List<Subcategory> subcategories;

    public ProductAttribute(String name) {
        this.name = name;
        this.subcategories=new ArrayList<Subcategory>();
    }

    public ProductAttribute(int id, String name, List<AttributeValue> attributeValues) {
        this.id = id;
        this.name = name;
        this.attributeValues = attributeValues;
        this.subcategories=new ArrayList<Subcategory>();
    }

    public ProductAttribute() {
        this.subcategories=new ArrayList<Subcategory>();
    }
}
