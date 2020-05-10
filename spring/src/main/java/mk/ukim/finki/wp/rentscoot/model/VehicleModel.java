package mk.ukim.finki.wp.rentscoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private double pricePerMinute;
    @JsonIgnore
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
