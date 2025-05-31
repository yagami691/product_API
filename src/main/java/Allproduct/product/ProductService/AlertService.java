package Allproduct.product.ProductService;

import Allproduct.product.Product.Alert;
import Allproduct.product.Product.Product;
import Allproduct.product.ProductRepository.AlertRepository;
import Allproduct.product.ProductRepository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AlertService {
    private final AlertRepository alertRepository;
    private final ProductRepository productRepository;

    public AlertService(AlertRepository alertRepository, ProductRepository productRepository) {
        this.alertRepository = alertRepository;
        this.productRepository = productRepository;
    }


    public List<Alert> createAlertsForProducts(List<Long> productIds) {
        List<Alert> createdAlerts = new ArrayList<>();

        for (Long productId : productIds) {
            Optional<Product> productOpt = productRepository.findById(productId);

            if (productOpt.isPresent()) {
                Product product = productOpt.get();


                boolean exists = alertRepository.existsByProduct(product);
                if (!exists && product.getQuantity() < 5) {
                    Alert alert = new Alert();
                    alert.setProduct(product);
                    alert.setAlert("Low stock alert for product: " + product.getName());
                    createdAlerts.add(alertRepository.save(alert));
                }
            }else{
                throw new IllegalStateException("Product not found");
            }
        }

        return createdAlerts;
    }

}
