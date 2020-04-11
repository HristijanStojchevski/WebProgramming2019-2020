package mk.ukim.finki.wp.rentscoot.model;

import lombok.*;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;

    private String country;

    private String city;

    private String Municipality;

    private String address;

    private String description;

    //private Long latitude;
    //private Long longitude;
    @NonNull
    private Point coordinates;
    @NonNull
    private Point popupCoordinates;
    //private GeoPosition position;
    @OneToMany(mappedBy = "location")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "location")
    private List<Reservation> reservations;

}
