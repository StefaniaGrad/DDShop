package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.CartEntryDTO;
import dd.projects.DDShop.enitities.CartEntry;
import dd.projects.DDShop.mapperss.CartEntryMapper;
import dd.projects.DDShop.repositories.CartEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartEntryService {

    @Autowired
    private final CartEntryRepository cartEntryRepository;

    @Autowired
    private CartEntryMapper cartEntryMapper;


    public CartEntryService(CartEntryRepository cartEntryRepository) {
        this.cartEntryRepository = cartEntryRepository;
    }

    public CartEntryDTO create(CartEntryDTO cartEntryDTO) {
        CartEntry cartEntry = cartEntryMapper.CartEntryDTOToCartEntry(cartEntryDTO);
        return cartEntryMapper.CartEntryToCartEntryDTO(cartEntryRepository.save(cartEntry));
    }

    public void deleteById(int id) {
        cartEntryRepository.deleteById(id);
    }

    public CartEntryDTO updateCartEntryQuantity(int id, int newQuantity) {


        CartEntry cartEntry = cartEntryRepository.findById(id).get();
        cartEntry.setQuantity(newQuantity);
        cartEntry.setTotalPricePerEntry(newQuantity * cartEntry.getPricePerPice());
        if (newQuantity == 0) {
            cartEntryRepository.deleteById(id);
            return cartEntryMapper.CartEntryToCartEntryDTO(cartEntry);
        }
        return cartEntryMapper.CartEntryToCartEntryDTO(cartEntryRepository.save(cartEntry));
    }

    public void deleteCartEntry(int id) {
        cartEntryRepository.deleteById(id);
    }

    public List<CartEntryDTO> getCartEntriesOfByCartId(int id){
      return   cartEntryRepository.findByCartId(id).
              stream().
              map(cartEntry -> cartEntryMapper.CartEntryToCartEntryDTO(cartEntry)).
              collect(Collectors.toList());
    }



}
