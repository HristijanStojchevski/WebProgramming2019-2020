package mk.ukim.finki.wp.rentscoot.repository;

import mk.ukim.finki.wp.rentscoot.model.VehicleModel;

import java.util.List;
import java.util.Optional;

public interface VehicleModelRepository {
     VehicleModel addModel(VehicleModel vehicleModel);

    List<VehicleModel> getAllModels();

     void deleteModel(VehicleModel vehicleModel);

    Optional<VehicleModel> findModelById(String modelName);

}
