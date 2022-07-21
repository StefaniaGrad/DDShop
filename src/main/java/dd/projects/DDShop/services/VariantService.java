package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.VariantCreateDTO;
import dd.projects.DDShop.DTOs.VariantGetDTO;
import dd.projects.DDShop.enitities.ProductAttribute;
import dd.projects.DDShop.enitities.Subcategory;
import dd.projects.DDShop.enitities.Variant;
import dd.projects.DDShop.mapperss.VariantMapperImpl;
import dd.projects.DDShop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VariantService {

    @Autowired
    private final VariantRepository variantRepository;

    @Autowired
    private  final ProductRepository productRepository;

    @Autowired
    private final AssignedValueRepository assignedValueRepository;

    @Autowired
    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    private final ProductAttributeRepository productAttributeRepository;

    @Autowired
    private VariantMapperImpl variantMapper;

    public VariantService(VariantRepository variantRepository, ProductRepository productRepository, AssignedValueRepository assignedValueRepository, SubcategoryRepository subcategoryRepository, ProductAttributeRepository productAttributeRepository) {
        this.variantRepository = variantRepository;
        this.productRepository = productRepository;
        this.assignedValueRepository = assignedValueRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.productAttributeRepository = productAttributeRepository;
    }

    public VariantCreateDTO createVariant(int productId, VariantCreateDTO variantCreateDTO, List<Integer> assignedValueIds){
        Variant variant=variantMapper.VariantCreateDTOToVariant(variantCreateDTO);
        variant.setProduct(productRepository.findById(productId).get());
        Subcategory s=productRepository.findById(productId).get().getSubcategory();
        for(Integer i: assignedValueIds) {
            variant.getAssignedValues().add(assignedValueRepository.getReferenceById(i));
            ProductAttribute p=assignedValueRepository.getReferenceById(i).getProductAttribute();
            p.getSubcategories().add(s);
            productAttributeRepository.save(p);
            //s.getProductAttributes().add(productAttributeRepository.getReferenceById(assignedValueRepository.getReferenceById(i).getProductAttribute().getId()));
        }
        subcategoryRepository.save(s);
        VariantCreateDTO v=variantMapper.VariantToVariantCreateDTO(variantRepository.save(variant));
        v.setAssignedValuesIds(variant.getAssignedValues().stream().map(assignedValue -> assignedValue.getId()).collect(Collectors.toList()));
        return  v;
    }

    public List<VariantGetDTO> listAllVariants()
    {
        return variantRepository.findAll().stream().map(variant -> variantMapper.VariantToVariantGetDTO(variant)).collect(Collectors.toList());
    }

    public List<VariantGetDTO> listVariantsOfProduct(int productId)
    {
        return variantRepository.findByProductId(productId).stream().map(variant -> variantMapper.VariantToVariantGetDTO(variant)).collect(Collectors.toList());
    }

    public VariantGetDTO updateVariant(VariantGetDTO variantGetDTO) {
       Variant variant=variantMapper.VariantGetDTOToVariant(variantGetDTO);
        return variantMapper.VariantToVariantGetDTO(variantRepository.save(variant));}

    public void deleteVariantById(int id) {variantRepository.deleteById(id);}

}
