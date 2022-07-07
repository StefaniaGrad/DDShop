package dd.projects.DDShop.controllers;

import dd.projects.DDShop.enitities.Product;
import dd.projects.DDShop.enitities.User;
import dd.projects.DDShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    void create(@RequestBody Product product){
        productService.createProduct(product);
    }

    @GetMapping
    @ResponseBody
    List<Product> read(){
        return productService.getProducts();
    }

    @PutMapping
    @ResponseBody
    Product update(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){ productService.deleteProductById(id);}
    


}
