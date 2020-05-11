package mk.ukim.finki.wp.rentscoot.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "reservations")
    private List<Vehicle> vehicles;
    @ManyToOne
    private Promotion promotion;
    @ManyToOne
    private Location location;
    @ManyToOne
    private User client;

    private LocalDateTime dateSubmited;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    private LocalTime timeStart;

    private LocalTime timeEnd;

    private double totalPrice;

//    public void addVehicle(Vehicle vehicle){
//        this.vehicles.add(vehicle);
//        vehicle.getReservations().add(this);
//    }
//    public void removeVehicle(Vehicle vehicle){
//        this.vehicles.remove(vehicle);
//        vehicle.getReservations().remove(this);
//    }
}
