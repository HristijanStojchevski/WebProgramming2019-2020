package mk.ukim.finki.wp.rentscoot.repository.jpa;

import mk.ukim.finki.wp.rentscoot.model.VehicleModel;
import mk.ukim.finki.wp.rentscoot.repository.VehicleModelRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaVehicleModelRepositoryImpl implements VehicleModelRepository {
    private final JpaVehicleModelRepository repository;

    public JpaVehicleModelRepositoryImpl(JpaVehicleModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public VehicleModel addModel(VehicleModel vehicleModel) {
        return this.repository.save(vehicleModel);
    }

    @Override
    public List<VehicleModel> getAllModels() {
        return this.repository.findAll();
    }

    @Override
    public void deleteModel(VehicleModel vehicleModel) {
        this.repository.delete(vehicleModel);
    }

    @Override
    public Optional<VehicleModel> findModelById(String modelName) {
        return this.repository.findById(modelName);
    }
}
