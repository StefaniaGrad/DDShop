package dd.projects.DDShop.services;

import dd.projects.DDShop.enitities.Address;
import dd.projects.DDShop.enitities.User;
import dd.projects.DDShop.repositories.AddressRepository;
import dd.projects.DDShop.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressRepository getAddressRepository(){ return addressRepository;}

    public Address createAddress(Address address){ return addressRepository.save(address);}

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Address updateAddress(Address address){ return addressRepository.save(address);}

    public void deleteAddressById(int id){ addressRepository.deleteById(id);}


}
