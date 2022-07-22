package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.AddressDTO;
import dd.projects.DDShop.enitities.Address;
import dd.projects.DDShop.mapperss.AddressMapperImpl;
import dd.projects.DDShop.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private final AddressRepository addressRepository;

@Autowired
private AddressMapperImpl addressAddressDTOMapper;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressRepository getAddressRepository(){ return addressRepository;}

    public AddressDTO createAddress(AddressDTO addressDTO){
        Address address=addressAddressDTOMapper.addressDTOToAddress(addressDTO);
        addressRepository.save(address);
        return addressAddressDTOMapper.addressToAddressDTO(address);
    }

    public List<AddressDTO> getAddresses(){
        return addressRepository.findAll()
                .stream()
                .map(address -> addressAddressDTOMapper.addressToAddressDTO(address))
                .collect(Collectors.toList());
    }
    public AddressDTO updateAddress(AddressDTO addressDTO){
        Address address=addressAddressDTOMapper.addressDTOToAddress(addressDTO);
        addressRepository.save(address);
        return addressAddressDTOMapper.addressToAddressDTO(address);
    }

    public void deleteAddressById(int id){ addressRepository.deleteById(id);}


}
