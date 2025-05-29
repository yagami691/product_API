package Allproduct.product.ProductService;


import Allproduct.product.Product.Product;
import Allproduct.product.ProductRepository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ProductService {


    private final  ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        List<Product> products = productRepository.findProductById(product.getId());
        boolean exists = products.stream().anyMatch(
                p ->p.getName().equals(product.getName())
                        && p.getPrice() == product.getPrice() && p.getQuantity() == product.getQuantity()
        );
       if(!exists) productRepository.save(product);
       else throw new ResponseStatusException(HttpStatus.CONFLICT, "Product already exists");
    }

    public void updateProduct(Long id, double price, int quantity){
        Product  products = productRepository.findById(id)
                .orElseThrow( () -> new
                        IllegalStateException("product with id " + id + " not found"));
        if(price != products.getPrice()) products.setPrice(price);
        if(quantity != products.getQuantity()) products.setQuantity(quantity);
        productRepository.save(products);


    }
    public void deleteProduct(Long id){
        boolean exists = productRepository.existsById(id);
        if(exists) productRepository.deleteById(id);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + id + " not found");
    }
}
