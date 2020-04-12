package mk.ukim.finki.wp.rentscoot.service.implementation;

import mk.ukim.finki.wp.rentscoot.model.*;
import mk.ukim.finki.wp.rentscoot.repository.LocationRepository;
import mk.ukim.finki.wp.rentscoot.repository.PromotionRepository;
import mk.ukim.finki.wp.rentscoot.repository.ReservationRepository;
import mk.ukim.finki.wp.rentscoot.repository.UserRepository;
import mk.ukim.finki.wp.rentscoot.service.ReservationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Service
public class ReservationServiceImplementation implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final PromotionRepository promotionRepository;

    public ReservationServiceImplementation(ReservationRepository reservationRepository, LocationRepository locationRepository, UserRepository userRepository, PromotionRepository promotionRepository) {
        this.reservationRepository = reservationRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Reservation createReservation(Integer locationId, String modelName, Long userId, String promotionName, LocalDateTime dateSubmited, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return null;
    }

    @Override
    public Reservation updateReservation(Long id, Integer locationId, String modelName, Long userId, String promotionName, LocalDateTime dateSubmited, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {

    }

    @Override
    public void deleteAllDueReservations(LocalDate date) {

    }

    @Override
    public Reservation getReservation(Long id) {
        return null;
    }

    @Override
    public List<Reservation> findReservationsByUser(String email) {
        return null;
    }

    @Override
    public List<Reservation> findReservationsByLocation(Integer locationId) {
        return null;
    }

    @Override
    public List<Reservation> findReservationsByDate(LocalDate date) {
        return null;
    }

}
