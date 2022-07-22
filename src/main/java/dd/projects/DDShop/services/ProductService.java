package dd.projects.DDShop.services;

import dd.projects.DDShop.DTOs.ProductCreateDTO;
import dd.projects.DDShop.DTOs.ProductGetDTO;
import dd.projects.DDShop.enitities.Product;
import dd.projects.DDShop.enitities.Variant;
import dd.projects.DDShop.mapperss.ProductMapperImpl;
import dd.projects.DDShop.repositories.ProductRepository;
import dd.projects.DDShop.repositories.SubcategoryRepository;
import dd.projects.DDShop.repositories.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    private final VariantRepository variantRepository;

    @Autowired
    private ProductMapperImpl productMapper;

    public ProductService(ProductRepository productRepository, SubcategoryRepository subcategoryRepository, VariantRepository variantRepository) {
        this.productRepository = productRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.variantRepository = variantRepository;
    }
    public  ProductRepository getProductRepository(){return productRepository;}

    public ProductCreateDTO createProduct(Integer id,ProductCreateDTO productCreateDTO){
        Product product=productMapper.ProductCreateDTOToProduct(productCreateDTO);
        product.setSubcategory(subcategoryRepository.findById(id).get());
        return productMapper.ProductToProductCreateDTO(productRepository.save(product));}


    public List<ProductGetDTO> getProducts(){
        return productRepository.findAll().stream().map(product -> productMapper.ProductToProductGetDTO(product)).collect(Collectors.toList());
    }
    public ProductGetDTO updateProduct(ProductGetDTO product) {
        Product product1=productMapper.ProductGetDTOToProduct(product);
        return productMapper.ProductToProductGetDTO(productRepository.save(product1));}


    public void deleteProductById(int id) { productRepository.deleteById(id);}

    public ProductGetDTO getProductById(int id){
        return productMapper.ProductToProductGetDTO(productRepository.findById(id).get());
    }

    public void createVariant(int productId, Variant variant) {
        variant.setProduct(productRepository.findById(productId).get());
       variantRepository.save(variant);
    }
}
