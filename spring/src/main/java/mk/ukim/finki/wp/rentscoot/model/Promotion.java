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
public class Promotion {

    @Id
    private String name;

    private String description;
    @NonNull
    private double discount; //percentage from 0 to 1

    @OneToMany(mappedBy = "promotion")
    private List<Reservation> reservations;

    private LocalDate validFrom;

    private LocalDate validTo;

}
