package Allproduct.product.ProductRepository;

import Allproduct.product.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT p FROM Product p JOIN FETCH p.alerts a WHERE p.quantity < 5")
    List<Product> findLowStockProductsWithAlerts();

    List<Product> findProductById(Long id);
}
