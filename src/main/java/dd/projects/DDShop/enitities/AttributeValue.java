package dd.projects.DDShop.enitities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class AttributeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String value;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="product_attribute_id")
    private ProductAttribute productAttribute;

    @JsonManagedReference
    @OneToMany(mappedBy = "attributeValue", cascade = CascadeType.ALL)
    private List<AssignedValue> assignedValues;

    public AttributeValue(String value) {
        this.value = value;
        this.assignedValues=new ArrayList<AssignedValue>();
    }

    public AttributeValue() {
        this.assignedValues=new ArrayList<AssignedValue>();
    }

    public AttributeValue(int id, String value) {
        this.id = id;
        this.value = value;
        this.assignedValues=new ArrayList<AssignedValue>();
    }

    public void addAssignedValue(AssignedValue assignedValue){


            this.assignedValues.add(assignedValue);

    }
}
