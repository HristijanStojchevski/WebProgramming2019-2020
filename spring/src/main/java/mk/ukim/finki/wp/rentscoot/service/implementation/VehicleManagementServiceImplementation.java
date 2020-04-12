package mk.ukim.finki.wp.rentscoot.service.implementation;

import mk.ukim.finki.wp.rentscoot.model.Location;
import mk.ukim.finki.wp.rentscoot.model.Vehicle;
import mk.ukim.finki.wp.rentscoot.model.VehicleModel;
import mk.ukim.finki.wp.rentscoot.model.VehicleType;
import mk.ukim.finki.wp.rentscoot.service.VehicleManagementService;

import java.time.LocalDate;
import java.util.List;

public class VehicleManagementServiceImplementation implements VehicleManagementService {

    @Override
    public Vehicle addVehicle(String serialNo, String description, LocalDate dateBought, VehicleModel model, Location location) {
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
    public Vehicle updateVehicle(String serialNo, String description, LocalDate dateBought, VehicleModel model, Location location, boolean onTheRoad) {
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

}
