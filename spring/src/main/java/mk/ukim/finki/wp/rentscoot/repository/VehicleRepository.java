package mk.ukim.finki.wp.rentscoot.repository;

import mk.ukim.finki.wp.rentscoot.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    Vehicle addVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    void deleteVehicle(Vehicle vehicle);

    Optional<Vehicle> findVehicleById(String serialNo);

    boolean exists(String id);
}
