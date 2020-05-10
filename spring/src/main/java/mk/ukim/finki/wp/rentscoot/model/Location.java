package mk.ukim.finki.wp.rentscoot.model;

import lombok.*;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;

    private String country;

    private String city;

    private String Municipality;

    private String address;

    private String description;

//    private Long latitude;
//    private Long longitude;
    @NotNull
    private Point coordinates;
    @NotNull
    private Point popupCoordinates;
    //private GeoPosition position;
    @OneToMany(mappedBy = "location")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "location")
    private List<Reservation> reservations;

//    public void addVehicle(Vehicle vehicle){
//        this.vehicles.add(vehicle);
//    }
//    public void removeVehicle(Vehicle vehicle){
//        this.vehicles.remove(vehicle);
//    }
//    public void addReservation(Reservation reservation){
//        this.reservations.add(reservation);
//    }
//    public void removeReservation(Reservation reservation){
//        this.reservations.remove(reservation);
//    }
}
