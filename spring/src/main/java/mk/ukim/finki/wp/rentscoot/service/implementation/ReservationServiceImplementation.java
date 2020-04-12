package mk.ukim.finki.wp.rentscoot.service.implementation;

import mk.ukim.finki.wp.rentscoot.model.*;
import mk.ukim.finki.wp.rentscoot.service.ReservationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ReservationServiceImplementation implements ReservationService {
    @Override
    public Reservation createReservation(List<Vehicle> vehicles, Promotion promotion, Location location, User user, LocalDateTime dateSubmitied, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return null;
    }

    @Override
    public Reservation updateReservation(Long id,List<Vehicle> vehicles, Promotion promotion, Location location, User user,LocalDateTime dateSubmited, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
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
