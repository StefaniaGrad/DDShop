package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.CartDTO;
import dd.projects.DDShop.enitities.Cart;
import dd.projects.DDShop.mapperss.CartMapperImpl;
import dd.projects.DDShop.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private final CartRepository cartRepository;

    @Autowired
    private CartMapperImpl cartMapper;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartDTO createCart(CartDTO cartDTO){
        Cart cart=cartMapper.CartDTOToCart(cartDTO);
        return cartMapper.CartToCartDTO(cartRepository.save(cart));
    }

    public CartDTO getCartById(int id){
        return cartMapper.CartToCartDTO(cartRepository.findById(id).get());
    }
    public CartDTO updateCartTotalPrice(int id, int totalprice){
        Cart cart=cartRepository.findById(id).get();
        cart.setTotalPrice(totalprice);
        return cartMapper.CartToCartDTO(cartRepository.save(cart));
    }

    public void deleteCart(int id){
        cartRepository.deleteById(id);
    }
}
