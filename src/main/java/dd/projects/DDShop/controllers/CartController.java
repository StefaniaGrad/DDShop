package dd.projects.DDShop.controllers;

import dd.projects.DDShop.DTOs.UserDTO;
import dd.projects.DDShop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


}
