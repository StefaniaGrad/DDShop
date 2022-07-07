package dd.projects.DDShop.services;

import dd.projects.DDShop.enitities.Product;
import dd.projects.DDShop.enitities.User;
import dd.projects.DDShop.repositories.ProductRepository;
import dd.projects.DDShop.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public  ProductRepository getProductRepository(){return productRepository;}
    public Product createProduct(Product product){ return productRepository.save(product);}
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product updateProduct(Product product) { return productRepository.save(product);}
    public void deleteProductById(int id) { productRepository.deleteById(id);}
}
