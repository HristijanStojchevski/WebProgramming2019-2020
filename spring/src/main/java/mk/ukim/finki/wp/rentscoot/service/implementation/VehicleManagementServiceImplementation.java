package mk.ukim.finki.wp.rentscoot.service.implementation;

import mk.ukim.finki.wp.rentscoot.model.Location;
import mk.ukim.finki.wp.rentscoot.model.Vehicle;
import mk.ukim.finki.wp.rentscoot.model.VehicleModel;
import mk.ukim.finki.wp.rentscoot.model.VehicleType;
import mk.ukim.finki.wp.rentscoot.model.exceptions.InvalidLocationException;
import mk.ukim.finki.wp.rentscoot.model.exceptions.InvalidVehicleException;
import mk.ukim.finki.wp.rentscoot.repository.LocationRepository;
import mk.ukim.finki.wp.rentscoot.repository.VehicleModelRepository;
import mk.ukim.finki.wp.rentscoot.repository.VehicleRepository;
import mk.ukim.finki.wp.rentscoot.service.VehicleManagementService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        Vehicle vehicle = new Vehicle();
        vehicle.setSerialNo(serialNo);
        vehicle.setDescription(description);
        vehicle.setDateBought(dateBought);
        VehicleModel vehicleModel = this.modelRepository.findModelById(modelName).orElseThrow(InvalidVehicleException::new);
        vehicle.setModel(vehicleModel);
        Location location = this.locationRepository.findLocationById(locationId).orElseThrow(InvalidLocationException::new);
        vehicle.setLocation(location);
        return this.vehicleRepository.addVehicle(vehicle);
    }

    @Override
    public VehicleModel addModel(String name, String description, double pricePerMinute, VehicleType type) {
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setModelName(name);
        vehicleModel.setDescription(description);
        vehicleModel.setPricePerMinute(pricePerMinute);
        vehicleModel.setType(type);
        return this.modelRepository.addModel(vehicleModel);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return this.vehicleRepository.getAllVehicles();
    }

    @Override
    public List<VehicleModel> getAllModels() {
        return this.modelRepository.getAllModels();
    }

    @Override
    public Vehicle updateVehicle(String serialNo, String description, LocalDate dateBought, String modelName, Integer locationId, boolean onTheRoad) {
        Vehicle vehicle = this.vehicleRepository.findVehicleById(serialNo).orElseThrow(InvalidVehicleException::new);
        vehicle.setDescription(description);
        VehicleModel vehicleModel = this.modelRepository.findModelById(modelName).orElseThrow(InvalidVehicleException::new);
        vehicle.setModel(vehicleModel);
        Location location = this.locationRepository.findLocationById(locationId).orElseThrow(InvalidLocationException::new);
        vehicle.setLocation(location);
        vehicle.setOnTheRoad(onTheRoad);
        return this.vehicleRepository.addVehicle(vehicle);
    }

    @Override
    public VehicleModel updateModel(String oldName,String name, String description, double pricePerMinute, VehicleType type) {
        VehicleModel vehicleModel = this.modelRepository.findModelById(oldName).orElseThrow(InvalidVehicleException::new);
        vehicleModel.setDescription(description);
        vehicleModel.setPricePerMinute(pricePerMinute);
        vehicleModel.setType(type);
        this.modelRepository.deleteModel(vehicleModel);
        vehicleModel.setModelName(name);
        return this.modelRepository.addModel(vehicleModel);
    }

    @Override
    public void deleteVehicle(String serialNo) {
        Vehicle vehicle = this.vehicleRepository.findVehicleById(serialNo).orElseThrow(InvalidVehicleException::new);
        this.vehicleRepository.deleteVehicle(vehicle);
    }

    @Override
    public void deleteModel(String modelName) {
        VehicleModel vehicleModel = this.modelRepository.findModelById(modelName).orElseThrow(InvalidVehicleException::new);
        this.modelRepository.addModel(vehicleModel);
    }

    @Override
    public VehicleModel findModelById(String modelName) {
        return this.modelRepository.findModelById(modelName).orElseThrow(InvalidVehicleException::new);
    }

    @Override
    public Vehicle findVehicleById(String serialNo) {
        return this.vehicleRepository.findVehicleById(serialNo).orElseThrow(InvalidVehicleException::new);
    }

    @Override
    public List<Vehicle> findVehiclesBetweenIntervalOnAGivenLocation(Integer locationId, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        List<Vehicle> vehiclesOnLocation = this.vehicleRepository.getAllVehicles().stream().filter(vehicle -> locationId.equals(vehicle.getLocation().getId())).collect(Collectors.toList());
        return vehiclesOnLocation.stream().filter(isAvailable(startDate,startTime,endDate,endTime)).collect(Collectors.toList());
    }
    private Predicate<Vehicle> isAvailable(LocalDate startDate,LocalTime startTime,LocalDate endDate,LocalTime endTime) {
        return  v -> v.getReservations().stream()
                .noneMatch( reservation1 -> (startDate.isAfter(reservation1.getDateStart())
                        && startTime.isAfter(reservation1.getTimeStart()) && startDate.isBefore(reservation1.getDateEnd())
                        && startTime.isBefore(reservation1.getTimeEnd())) || (endDate.isAfter(reservation1.getDateStart())
                        && endTime.isAfter(reservation1.getTimeStart()) && endDate.isBefore(reservation1.getDateEnd())
                        && endTime.isBefore(reservation1.getTimeEnd()))
                );
    }
}
