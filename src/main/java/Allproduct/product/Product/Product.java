package Allproduct.product.Product;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private double price;
    private int quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Alert> alerts = new ArrayList<>();


    public Product(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
