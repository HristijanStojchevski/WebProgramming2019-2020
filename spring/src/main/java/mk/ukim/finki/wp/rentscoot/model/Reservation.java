package mk.ukim.finki.wp.rentscoot.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;
    @ManyToOne
    private Promotion promotion;
    @ManyToOne
    private Location location;
    @ManyToOne
    private User client;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    private LocalTime timeStart;

    private LocalTime timeEnd;

    private double totalPrice;
}
