package dd.projects.DDShop.controllers;

import dd.projects.DDShop.DTOs.ProductCreateDTO;
import dd.projects.DDShop.DTOs.ProductGetDTO;
import dd.projects.DDShop.enitities.Product;
import dd.projects.DDShop.enitities.Subcategory;
import dd.projects.DDShop.enitities.User;
import dd.projects.DDShop.enitities.Variant;
import dd.projects.DDShop.repositories.VariantRepository;
import dd.projects.DDShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    VariantRepository variantRepository;

    @PostMapping("/subcategoryId={id}")
    ProductCreateDTO create(@PathVariable Integer id,@RequestBody ProductCreateDTO productCreateDTO){
       return productService.createProduct(id,productCreateDTO);
    }

    @GetMapping
    @ResponseBody
    List<ProductGetDTO> read(){
        return productService.getProducts();
    }

    @PutMapping
    @ResponseBody
    ProductGetDTO update(@RequestBody ProductGetDTO product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){ productService.deleteProductById(id);}

    @GetMapping("/{id}")
    @ResponseBody
    ProductGetDTO getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @GetMapping("/variantsOfProduct{id}")
    @ResponseBody
    List<Variant> findVariantsForProduct(@PathVariable Integer id){
        return variantRepository.findByProductId(id);
    }




}
