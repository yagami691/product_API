package Allproduct.product;

import Allproduct.product.Product.Product;
import Allproduct.product.ProductRepository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product wirelessMouse = new Product(
                     "Wireless Mouse",
                    25.99,
                    150
            );
            Product bluetoothHeadphones = new Product(
                    "Bluetooth Headphones",
                    79.99,
                    80
            );
            Product coffeeMaker = new Product(
                    "Coffee Maker",
                    49.50,
                    3
            );
            Product yogaMat = new Product(
                    "Yoga Mat",
                    19.99,
                    200
            );
            Product laptopStand= new Product(
                    "Laptop Stand",
                    34.99,
                    120
            );
            Product usbChargingCable = new Product(
                    "USB-C Charging Cable",
                    9.99,
                    300
            );
            Product smartwatch = new Product(
                    "Smartwatch",
                    149.00,
                    4
            );

            productRepository.saveAll(List.of(wirelessMouse,bluetoothHeadphones,coffeeMaker,
                    laptopStand,usbChargingCable,smartwatch));
        };
    }
}
