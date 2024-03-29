package mk.ukim.finki.wp.rentscoot.repository.jpa;

import mk.ukim.finki.wp.rentscoot.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JpaReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByDateStartEquals(LocalDate date);
}
