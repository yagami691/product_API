package Allproduct.product.ProductController;


import Allproduct.product.Product.Product;
import Allproduct.product.ProductService.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/allProducts")
    public List<Product> getAllProducts() {
       return  productService.getProducts();

    }

    @PostMapping(path = "/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
                return ResponseEntity.status(HttpStatus.CREATED).body("Product Added with successful");

    }

    @PutMapping(path ="/{productId}")
    public ResponseEntity<String> updateProduct(
            @PathVariable Long productId, @RequestBody Product product) {
            productService.updateProduct(productId,
                    product.getPrice(), product.getQuantity());
            return ResponseEntity.ok("Product Updated with successful");
    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product Deleted with successful");
    }
}
