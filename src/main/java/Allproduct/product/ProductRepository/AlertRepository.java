package Allproduct.product.ProductRepository;

import Allproduct.product.Product.Alert;
import Allproduct.product.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AlertRepository extends JpaRepository<Alert, Long> {

    boolean existsByProduct(Product product);
}
