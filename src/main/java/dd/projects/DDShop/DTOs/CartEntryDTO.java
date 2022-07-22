package dd.projects.DDShop.DTOs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dd.projects.DDShop.enitities.Cart;
import dd.projects.DDShop.enitities.CartEntry;
import dd.projects.DDShop.enitities.User;
import dd.projects.DDShop.enitities.Variant;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
public class CartEntryDTO {

    private int id;

    private int quantity;

    private VariantGetDTO variant;

    private int pricePerPice;

    private int totalPricePerEntry;


}
