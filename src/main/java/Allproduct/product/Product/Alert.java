package Allproduct.product.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String alert;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
