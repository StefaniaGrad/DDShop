package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.ProductAttributeCreateDTO;
import dd.projects.DDShop.DTOs.ProductAttributeGetDTO;
import dd.projects.DDShop.enitities.ProductAttribute;
import dd.projects.DDShop.mapperss.ProductAttributeMapperImpl;
import dd.projects.DDShop.repositories.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductAttributeService {

    @Autowired
    private final ProductAttributeRepository productAttributeRepository;

    @Autowired
    private ProductAttributeMapperImpl productAttributeMapper;


    public ProductAttributeService(ProductAttributeRepository productAttributeRepository) {
        this.productAttributeRepository = productAttributeRepository;
    }

    public ProductAttributeCreateDTO create(ProductAttributeCreateDTO productAttributeCreateDTO)
    {
        ProductAttribute productAttribute=productAttributeMapper.ProductAttributeCreateDTOToProductAttribute(productAttributeCreateDTO);
        return productAttributeMapper.ProductAttributeToProductAttributeCreateDTO(productAttributeRepository.save(productAttribute));
    }

    public List<ProductAttributeGetDTO> getAllProductAttributes(){
        return productAttributeRepository.findAll()
                .stream().
                map(productAttribute -> productAttributeMapper.ProductAttributeToProductAttributeGetDTO(productAttribute)).
                collect(Collectors.toList());
    }

    public ProductAttributeGetDTO update(ProductAttributeGetDTO productAttributeGetDTO){
        ProductAttribute productAttribute=productAttributeMapper.ProductAttributeGetDTOToProductAttribute(productAttributeGetDTO);
        return productAttributeMapper.ProductAttributeToProductAttributeGetDTO(productAttributeRepository.save(productAttribute));
    }

    public void deleteById(int id){
        productAttributeRepository.deleteById(id);
    }

    public ProductAttributeGetDTO findById(int id){
        ProductAttribute productAttribute=productAttributeRepository.findById(id).get();
        return productAttributeMapper.ProductAttributeToProductAttributeGetDTO(productAttribute);
    }



}
