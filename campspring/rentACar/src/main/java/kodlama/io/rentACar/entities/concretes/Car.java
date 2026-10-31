package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="cars")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="plate", unique=true)
    private String plate;
    
    @Column(name="daily_price")
    private double dailyPrice;
    
    @Column(name="model_year")
    private int modelYear;
    
    @Column(name="state")
    private int state;  // 1-Available 2-Rented 3-Maintenance

//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "brand_id", referencedColumnName = "id")
//    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Model model;

    public Brand getBrand() {
        return model != null ? model.getBrand() : null;
    }
} 