package dd.projects.DDShop.enitities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class CartEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="variant_id")
    private Variant variant;

    private int pricePerPice;

    private int totalPricePerEntry;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

}
