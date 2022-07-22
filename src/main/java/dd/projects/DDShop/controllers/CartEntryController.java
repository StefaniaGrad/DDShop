package dd.projects.DDShop.controllers;

import dd.projects.DDShop.services.CartEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart-entry")
public class CartEntryController {

    @Autowired
    private final CartEntryService cartEntryService;

    public CartEntryController(CartEntryService cartEntryService) {
        this.cartEntryService = cartEntryService;
    }


}
