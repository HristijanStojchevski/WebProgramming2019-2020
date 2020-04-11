package mk.ukim.finki.wp.rentscoot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    @Id
    private String serialNo;

    private String description;
    @NonNull
    private LocalDate dateBought;
    @ManyToOne
    @NonNull
    private VehicleModel model;
    @ManyToOne
    private Location location;
    @OneToMany(mappedBy = "vehicle")
    private List<Reservation> reservations;
}
