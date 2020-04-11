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
public class Promotion {

    @Id
    private String name;

    private String description;
    @NonNull
    private double discount;

    @OneToMany(mappedBy = "promotion")
    private List<Reservation> reservations;
}
