package mk.ukim.finki.wp.rentscoot.service.implementation;

import mk.ukim.finki.wp.rentscoot.model.Location;
import mk.ukim.finki.wp.rentscoot.model.exceptions.InvalidLocationException;
import mk.ukim.finki.wp.rentscoot.repository.LocationRepository;
import mk.ukim.finki.wp.rentscoot.service.LocationsService;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationsServiceImplementation implements LocationsService {
    private final LocationRepository locationRepository;

    public LocationsServiceImplementation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location createLocation(String name, String country, String city, String municipality, String address, String description, Point coordinates, Point popupCoordinates) {
        Location location = new Location();
        location.setName(name);
        location.setCountry(country);
        location.setCity(city);
        location.setAddress(address);
        location.setMunicipality(municipality);
        location.setCoordinates(coordinates);
        location.setPopupCoordinates(popupCoordinates);
        return this.locationRepository.createLocation(location);
    }

    @Override
    public Location updateLocation(Integer id,String name, String country, String city, String municipality, String address, String description, Point coordinates, Point popupCoordinates){
        Location oldLocation = this.locationRepository.findLocationById(id).orElseThrow(InvalidLocationException::new);
        return null;
    }

    @Override
    public List<Location> getAllLocations() {
        return null;
    }

    @Override
    public void deleteLocation(Integer id) {

    }

    @Override
    public Location getLocation(Integer id) {
        return null;
    }

    @Override
    public List<Location> findLocationsByCityOrCountry(String place,String country) {
        return null;
    }

    @Override
    public List<Location> searchLocations(String term) {
        return null;
    }
}
