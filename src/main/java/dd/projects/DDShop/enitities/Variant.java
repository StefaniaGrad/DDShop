package dd.projects.DDShop.enitities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    private int price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "variant_assigned_value",
            joinColumns = @JoinColumn(name = "variant_id"),
            inverseJoinColumns = @JoinColumn(name = "assigned_value_id"))
    private List<AssignedValue> assignedValues;

    public Variant() {
        this.assignedValues = new ArrayList<AssignedValue>();
    }

    public Variant(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
        this.assignedValues = new ArrayList<AssignedValue>();
    }

    public Variant(int id, int quantity, int price, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.assignedValues =new ArrayList<AssignedValue>();
    }

    public Variant(int id, int quantity, int price, Product product, List<AssignedValue> assignedValues) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.assignedValues = new ArrayList<AssignedValue>();
    }
}
