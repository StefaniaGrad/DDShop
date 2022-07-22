package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.AttributeValueCreateDTO;
import dd.projects.DDShop.DTOs.AttributeValueGetDTO;
import dd.projects.DDShop.enitities.AssignedValue;
import dd.projects.DDShop.enitities.AttributeValue;
import dd.projects.DDShop.enitities.ProductAttribute;
import dd.projects.DDShop.mapperss.AttributeValueMapperImpl;
import dd.projects.DDShop.repositories.AssignedValueRepository;
import dd.projects.DDShop.repositories.AttributeValueRepository;
import dd.projects.DDShop.repositories.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeValueService {

    @Autowired
    private final AttributeValueRepository attributeValueRepository;

    @Autowired
    private  final ProductAttributeRepository productAttributeRepository;

    @Autowired
    private final AssignedValueRepository assignedValueRepository;

    @Autowired
    private AttributeValueMapperImpl attributeValueMapper;

    @Autowired
    private AssignedValueService assignedValueService;

    public AttributeValueService(AttributeValueRepository attributeValueRepository, ProductAttributeRepository productAttributeRepository, AssignedValueRepository assignedValueRepository) {
        this.attributeValueRepository = attributeValueRepository;
        this.productAttributeRepository = productAttributeRepository;
        this.assignedValueRepository = assignedValueRepository;
    }

    public AttributeValueGetDTO create(int id, AttributeValueCreateDTO attributeValueCreateDTO){

        AttributeValue attributeValue=attributeValueMapper.AttributeValueCreateDTOToAttributeValue(attributeValueCreateDTO);
        AttributeValueGetDTO a=attributeValueMapper.AttributeValueToAttributeValueGetDTO(attributeValueRepository.save(attributeValue));
        ProductAttribute productAttribute=productAttributeRepository.findById(id).get();
        attributeValue.setProductAttribute(productAttribute);

        AssignedValue assignedValue=new AssignedValue(productAttribute,attributeValue);
        assignedValueRepository.save(assignedValue);
        attributeValue.addAssignedValue(assignedValue);

        return attributeValueMapper.AttributeValueToAttributeValueGetDTO(attributeValueRepository.save(attributeValue));
    }


    public List<AttributeValueGetDTO> attributeValueGetDTOList(int id){
        return attributeValueRepository.findByProductAttributeId(id).
                stream().
                map(attributeValue -> attributeValueMapper.AttributeValueToAttributeValueGetDTO(attributeValue)).
                collect(Collectors.toList());
    }

    public AttributeValueGetDTO update(AttributeValueGetDTO attributeValueGetDTO){
        AttributeValue attributeValue=attributeValueMapper.AttributeValueGetDTOToAttributeValue(attributeValueGetDTO);
        return attributeValueMapper.AttributeValueToAttributeValueGetDTO(attributeValueRepository.save(attributeValue));
    }

    public void delete(int id)
    {
        attributeValueRepository.deleteById(id);
    }

    public AttributeValueGetDTO getAttributeById(int id){
        return attributeValueMapper.AttributeValueToAttributeValueGetDTO(attributeValueRepository.findById(id).get());
    }
}
