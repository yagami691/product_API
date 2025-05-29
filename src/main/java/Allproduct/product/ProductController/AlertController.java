package Allproduct.product.ProductController;


import Allproduct.product.Product.Alert;
import Allproduct.product.ProductService.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping (path = "api/products")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }


    @PostMapping("/createAlert")
    public ResponseEntity<List<Alert>> createAlerts(@RequestBody Map<String, List<Long>> request) {
        List<Long> productIds = request.get("productIds");

        List<Alert> createdAlerts = alertService.createAlertsForProducts(productIds);

        return ResponseEntity.ok(createdAlerts);
    }
}
