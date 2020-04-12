package mk.ukim.finki.wp.rentscoot.service.implementation;

import mk.ukim.finki.wp.rentscoot.model.Vehicle;
import mk.ukim.finki.wp.rentscoot.model.VehicleModel;
import mk.ukim.finki.wp.rentscoot.model.VehicleType;
import mk.ukim.finki.wp.rentscoot.repository.LocationRepository;
import mk.ukim.finki.wp.rentscoot.repository.VehicleModelRepository;
import mk.ukim.finki.wp.rentscoot.repository.VehicleRepository;
import mk.ukim.finki.wp.rentscoot.service.VehicleManagementService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Service
public class VehicleManagementServiceImplementation implements VehicleManagementService {
    private final VehicleRepository vehicleRepository;
    private final VehicleModelRepository modelRepository;
    private final LocationRepository locationRepository;

    public VehicleManagementServiceImplementation(VehicleRepository vehicleRepository, VehicleModelRepository modelRepository, LocationRepository locationRepository) {
        this.vehicleRepository = vehicleRepository;
        this.modelRepository = modelRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Vehicle addVehicle(String serialNo, String description, LocalDate dateBought, String modelName, Integer locationId) {
        return null;
    }

    @Override
    public VehicleModel addModel(String name, String description, double pricePerMinute, VehicleType type) {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return null;
    }

    @Override
    public List<VehicleModel> getAllModels() {
        return null;
    }

    @Override
    public Vehicle updateVehicle(String serialNo, String description, LocalDate dateBought, String modelName, Integer locationId, boolean onTheRoad) {
        return null;
    }

    @Override
    public VehicleModel updateModel(String name, String description, double pricePerMinute, VehicleType type) {
        return null;
    }

    @Override
    public void deleteVehicle(String serialNo) {

    }

    @Override
    public void deleteModel(String modelName) {

    }

    @Override
    public VehicleModel findModelById(String modelName) {
        return null;
    }

    @Override
    public Vehicle findVehicleById(String serialNo) {
        return null;
    }

    @Override
    public List<Vehicle> findVehiclesBetweenIntervalOnAGivenLocation(Integer locationId, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return null;
    }
}
