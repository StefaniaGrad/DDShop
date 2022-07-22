package dd.projects.DDShop.enitities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy = "subcategory",cascade = CascadeType.ALL)
    private List<Product> products;

    @JsonBackReference
    @ManyToMany(mappedBy = "subcategories")
    private List<ProductAttribute> productAttributes;

    public Subcategory(String name, List<Product> products, List<ProductAttribute> productAttributes) {
        this.name = name;
        this.products = products;
        this.productAttributes = productAttributes;
        this.products=new ArrayList<Product>();
    }

    public Subcategory() {
        this.productAttributes=new ArrayList<ProductAttribute>();
        this.products=new ArrayList<Product>();
    }

    public Subcategory(String name) {
        this.name = name;
        this.productAttributes=new ArrayList<ProductAttribute>();
        this.products=new ArrayList<Product>();
    }

    public Subcategory(int id, String name, List<Product> products, List<ProductAttribute> productAttributes) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.productAttributes = productAttributes;
        this.products=new ArrayList<Product>();
    }
}
