package mk.ukim.finki.wp.rentscoot.repository.jpa;

import mk.ukim.finki.wp.rentscoot.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVehicleRepository extends JpaRepository<Vehicle,String> {
}
