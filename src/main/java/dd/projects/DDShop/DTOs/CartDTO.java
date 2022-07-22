package dd.projects.DDShop.DTOs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dd.projects.DDShop.enitities.CartEntry;
import dd.projects.DDShop.enitities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
public class CartDTO {

    private int id;

    private UserDTO user;

    private int totalPrice;

    private List<CartEntryDTO> cartEntries;

}
