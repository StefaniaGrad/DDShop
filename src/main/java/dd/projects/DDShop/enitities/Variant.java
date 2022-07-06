package dd.projects.DDShop.enitities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Sel_Var",
            joinColumns = @JoinColumn(name = "sel_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "variant_id",
                    referencedColumnName = "id"))
    private List<Sel> sels;


}
