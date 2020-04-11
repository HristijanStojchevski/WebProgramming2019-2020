package mk.ukim.finki.wp.rentscoot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleModel {
    @Id
    private String modelName;
    /*
    @Enumerated(EnumType.STRING)
    private VehicleType type;
    */
    private String descripiton;
    @NonNull
    private double pricePerHour;
    @OneToMany(mappedBy = "model")
    private List<Vehicle> vehicles;

    private int amountAvailable;
}
