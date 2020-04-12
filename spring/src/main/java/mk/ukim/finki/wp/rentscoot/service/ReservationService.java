package mk.ukim.finki.wp.rentscoot.service;

import mk.ukim.finki.wp.rentscoot.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface ReservationService {
    Reservation createReservation(List<Vehicle> vehicles, Promotion promotion, Location location, User user, LocalDateTime dateSubmited, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime);

    Reservation updateReservation(Long id,List<Vehicle> vehicles, Promotion promotion, Location location, User user,LocalDateTime dateSubmited, LocalDate startDate, LocalTime startTime,LocalDate endDate,LocalTime endTime);

    List<Reservation> getAllReservations();

    void deleteReservation(Long id);

    void deleteAllDueReservations(LocalDate date);

    Reservation getReservation(Long id);

    List<Reservation> findReservationsByUser(String email);

    List<Reservation> findReservationsByLocation(Integer locationId);

    List<Reservation> findReservationsByDate(LocalDate date);

}

