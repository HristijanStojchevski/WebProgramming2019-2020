package mk.ukim.finki.wp.rentscoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.security.AuthProvider;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "client")
    private List<Reservation> reservation;

    @NonNull
    private String name;

    @Email
    @NonNull
    private String email;

    /*@NonNull
    private Boolean emailVerified = false;*/

    @JsonIgnore
    private String password;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Role role = Role.CLIENT;

    /*@NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerID;*/

}
