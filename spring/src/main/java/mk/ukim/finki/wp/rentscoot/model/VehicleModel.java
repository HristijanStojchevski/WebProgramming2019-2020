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

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private String description;
    @NonNull
    private double pricePerMinute;
    @OneToMany(mappedBy = "model")
    private List<Vehicle> vehicles;

    private int amountAvailable=0;

//    void addVehicle(Vehicle vehicle){
//        this.vehicles.add(vehicle);
//    }
//    void removeVehicle(Vehicle vehicle){
//        this.vehicles.remove(vehicle);
//    }
}
