package mk.ukim.finki.wp.rentscoot.service;

import mk.ukim.finki.wp.rentscoot.model.Location;
import mk.ukim.finki.wp.rentscoot.model.Vehicle;
import mk.ukim.finki.wp.rentscoot.model.VehicleModel;
import mk.ukim.finki.wp.rentscoot.model.VehicleType;

import java.time.LocalDate;
import java.util.List;

public interface VehicleManagementService {
    Vehicle addVehicle(String serialNo, String description, LocalDate dateBought, VehicleModel model, Location location);
    VehicleModel addModel(String name, String  description, double pricePerMinute, VehicleType type);

    List<Vehicle> getAllVehicles();
    List<VehicleModel> getAllModels();

    Vehicle updateVehicle(String serialNo, String description, LocalDate dateBought, VehicleModel model, Location location,boolean onTheRoad);
    VehicleModel updateModel(String name, String  description, double pricePerMinute, VehicleType type);

    void deleteVehicle(String serialNo);
    void deleteModel(String modelName);

    VehicleModel findModelById(String modelName);
    Vehicle findVehicleById(String serialNo);


}
