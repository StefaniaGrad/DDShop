package dd.projects.DDShop.enitities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "category",  cascade = CascadeType.ALL)
    private List<Subcategory> subcategories;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public Category(int id, String name, List<Subcategory> subcategories) {
        this.id = id;
        this.name = name;
        this.subcategories = subcategories;
    }
}
