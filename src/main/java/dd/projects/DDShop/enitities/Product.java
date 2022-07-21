package dd.projects.DDShop.enitities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="subcategory_id")
    private Subcategory subcategory;

    @JsonManagedReference
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Variant> variants;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Product(int id, String name, String description, List<Variant> variants) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.variants = variants;
    }

    public Product() {
    }
}
