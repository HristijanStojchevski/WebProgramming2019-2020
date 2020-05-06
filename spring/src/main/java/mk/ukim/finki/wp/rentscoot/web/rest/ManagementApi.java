package mk.ukim.finki.wp.rentscoot.web.rest;

import mk.ukim.finki.wp.rentscoot.model.*;
import mk.ukim.finki.wp.rentscoot.service.*;
import org.springframework.data.geo.Point;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "api/manage", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ManagementApi {
    private final LocationsService locationsService;
    private final PromotionService promotionService;
    private final ReservationService reservationService;
    private final UserManagementService userService;
    private final VehicleManagementService vehicleService;

    public ManagementApi(LocationsService locationsService, PromotionService promotionService, ReservationService reservationService, UserManagementService userService, VehicleManagementService vehicleService) {
        this.locationsService = locationsService;
        this.promotionService = promotionService;
        this.reservationService = reservationService;
        this.userService = userService;
        this.vehicleService = vehicleService;
    }
// LOCATIONS ENDPOINT
    @GetMapping("/locations")
    public List<Location> getAllLocations(@RequestHeader(name="city", defaultValue = "",required = false) String city,
                                          @RequestHeader(name="country", defaultValue = "",required = false) String country,
                                          @RequestParam(value = "term",required = false) String term){
        if(!city.equals("") || !country.equals("")) return this.locationsService.findLocationsByCityOrCountry(city,country);
        if(term!=null) return this.locationsService.searchLocations(term);
        return this.locationsService.getAllLocations();
    }

    @GetMapping("/locations/{locationId}")
    public Location getLocation(@PathVariable Integer locationId){
        return this.locationsService.getLocation(locationId);
    }
    @PostMapping("/locations")
    @ResponseStatus(HttpStatus.CREATED)
    public Location createLocation(@RequestParam("name") String name,
                                   @RequestParam("country") String country,
                                   @RequestParam("city") String city,
                                   @RequestParam(value = "municipality",required = false) String municipality,
                                   @RequestParam(value = "address",required = false) String address,
                                   @RequestParam(value = "description",required = false) String description,
                                   @RequestParam("coordinates") Point coordinates,
                                   @RequestParam(value = "popupCoordinates",required = false) Point popupCoordinates,
                                   HttpServletResponse response,
                                   UriComponentsBuilder builder){
        Location result = this.locationsService.createLocation(name,country,city,municipality,address,description,coordinates,popupCoordinates);
        response.setHeader("Location",builder.path("api/manage/locations/{locationId}").buildAndExpand(result.getId()).toUriString());
        return result;
    }

    @PatchMapping("/locations/{locationId}")
    public Location updateLocation(@PathVariable int locationId,
                                   @RequestParam String name,
                                   @RequestParam String country,
                                   @RequestParam("city") String city,
                                   @RequestParam(value = "municipality",required = false) String municipality,
                                   @RequestParam(value = "address",required = false) String address,
                                   @RequestParam(value = "description",required = false) String description,
                                   @RequestParam("coordinates") Point coordinates,
                                   @RequestParam(value = "popupCoordinates",required = false) Point popupCoordinates){
        return this.locationsService.updateLocation(locationId,name,country,city,municipality,address,description,coordinates,popupCoordinates);
    }

    @DeleteMapping("/locations/{locationId}")
    public void deleteLocation(@PathVariable int locationId) {
        this.locationsService.deleteLocation(locationId);
    }
// MODELS AND VEHICLES ENDPOINTS
    @GetMapping("/models")
    public List<VehicleModel> getAllModels(){
    return this.vehicleService.getAllModels();
}
    @GetMapping("/models/{modelName}")
    public VehicleModel getModel(@PathVariable String modelName){
        return this.vehicleService.findModelById(modelName);
    }
    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles(){
        return this.vehicleService.getAllVehicles();
    }
    @PostMapping("/vehicles")
    public Vehicle addVehicle(@RequestParam(name = "serialNo") String serialNo,
                              @RequestParam(name = "description") String description,
                              @RequestParam(name = "dateBought", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateBought,
                              @RequestParam(name = "modelName") String modelName,
                              @RequestParam(name = "locationId") int locationId,
                              HttpServletResponse response,
                              UriComponentsBuilder builder){
        if(dateBought==null){
            dateBought = LocalDate.now();
        }
        Vehicle result = this.vehicleService.addVehicle(serialNo,description,dateBought,modelName,locationId);
        response.setHeader("Location",builder.path("/api/manage/vehicles/{vehicleId}").buildAndExpand(result.getSerialNo()).toUriString());
        return result;
    }
    @PostMapping("/models")
    public VehicleModel addModel(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "description") String description,
                                 @RequestParam(name = "pricePerMinute") double pricePerMinute,
                                 @RequestParam(name = "vehicleType") String vehicleType,
                                 HttpServletResponse response,
                                 UriComponentsBuilder builder){
        VehicleModel result = this.vehicleService.addModel(name,description,pricePerMinute,VehicleType.valueOf(vehicleType));
        response.setHeader("Location",builder.path("/api/manage/models/{modelId}").buildAndExpand(result.getModelName()).toUriString());
        return result;
    }
    @PatchMapping("/vehicles/{serialNo}")
    public Vehicle updateVehicle(@PathVariable String serialNo,
                                 @RequestParam(name = "description",required = false) String description,
                                 @RequestParam(name = "dateBought",required = false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate dateBought,
                                 @RequestParam(name = "modelName", required = false) String modelName,
                                 @RequestParam(name = "locationId",required = false) Integer locationId,
                                 @RequestParam(name = "onTheRoad",required = false) boolean onTheRoad){
        return this.vehicleService.updateVehicle(serialNo,description,dateBought,modelName,locationId,onTheRoad);
    }
    @PatchMapping("/models/{oldName}")
    public VehicleModel updateModel(@PathVariable String oldName,
                                    @RequestParam(name = "name", required = false) String name,
                                    @RequestParam(name = "description",required = false) String  description,
                                    @RequestParam(name = "pricePerMinute") double pricePerMinute,
                                    @RequestParam(name = "vehicleType") String vehicleType){
        return this.vehicleService.updateModel(oldName,name,description,pricePerMinute,VehicleType.valueOf(vehicleType));
    }
    @DeleteMapping("/vehicles/{serialNo}")
    public void deleteVehicle(@PathVariable String serialNo){
        this.vehicleService.deleteVehicle(serialNo);
    }
    @DeleteMapping("/models/{modelName}")
    public void deleteModel(@PathVariable String modelName){
        this.vehicleService.deleteModel(modelName);
    }
    @GetMapping("vehicles/{serialNo}")
    public Vehicle findVehicleById(@PathVariable String serialNo){
        return this.vehicleService.findVehicleById(serialNo);
    }

    @GetMapping("/vehicles")// might be pageable
    public List<Vehicle> getVehicles(){
        return this.vehicleService.getAllVehicles();
    }

// PROMOTIONS ENDPOINT
    @PostMapping("/promotions")
    Promotion createPromotion(@RequestParam(name = "name") String name,
                              @RequestParam(name = "description",required = false) String description,
                              @RequestParam(name = "discount") double discount,
                              @RequestParam(name = "validFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate validFrom,
                              @RequestParam(name = "validTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate validTo,
                              HttpServletResponse response,
                              UriComponentsBuilder builder){
        Promotion result = this.promotionService.createPromotion(name,description,discount,validFrom,validTo);
        response.setHeader("Location",builder.path("/api/manage/promotions/{promoId}").buildAndExpand(result.getName()).toUriString());
        return result;
    }
    @GetMapping("/promotions")
    public List<Promotion> getAllPromotions(){
        return this.promotionService.getAllPromotions();
    }
    @GetMapping("/promotions/{name}")
    public Promotion getPromotion(@PathVariable String name){
        return this.promotionService.getPromotion(name);
    }
    @PatchMapping("/promotions/{name}")
    public Promotion updatePromotion(@PathVariable String name,
                                     @RequestParam(name = "description",required = false) String description,
                                     @RequestParam(name = "discount") double discount,
                                     @RequestParam(name = "validFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate validFrom,
                                     @RequestParam(name = "validTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate validTo){
        return this.promotionService.updatePromotion(name,description,discount,validFrom,validTo);
    }
    @DeleteMapping("/promotions/{name}")
    public void deletePromotion(@PathVariable String name){
        this.promotionService.deletePromotion(name);
    }

// RESERVATIONS ENDPOINT
    @PostMapping("/reservations")
    public Reservation addReservation(@RequestHeader(name="userEmail") String email,
                                      @RequestHeader(name="locationId") int locationId,
                                      @RequestHeader(name="modelNames") String modelNames,
                                      @RequestHeader(name = "promotion") String promotion,
                                      @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                      @RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
                                      @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                      @RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime,
                                      HttpServletResponse response,
                                      UriComponentsBuilder builder){
        //list of models ex: bike,bike,scoot,scoot,scoot
        String[] modelName = modelNames.split(",");
        User user = this.userService.getUserByEmail(email);
        Reservation result = this.reservationService.createReservation(locationId,modelName,user.getId(),promotion,startDate,startTime,endDate,endTime);
        response.setHeader("Location",builder.path("/api/rental/reservations/{reservationId}").buildAndExpand(result.getId()).toUriString());
        return result;
    }
    @PatchMapping("/reservations/{reservationId}")
    public Reservation updateReservation(@PathVariable Long reservationId,
                                         @RequestHeader(name="locationId") int locationId,
                                         @RequestHeader(name="modelNames") String modelNames,
                                         @RequestHeader(name = "promotion") String promotion,
                                         @RequestHeader(name="userEmail") String email,
                                         @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                         @RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
                                         @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                         @RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime){
        //list of models ex: bike,bike,scoot,scoot,scoot
        String[] modelName = modelNames.split(",");
        User user = this.userService.getUserByEmail(email);
        return this.reservationService.updateReservation(reservationId,locationId,modelName,user.getId(),promotion,startDate,startTime,endDate,endTime);
    }
    @GetMapping("/reservations")
    public List<Reservation> getAllReservations(){
        return this.reservationService.getAllReservations();
    }
    @DeleteMapping("/reservations/{reservationId}")
    public void deleteReservation(@PathVariable Long reservationId){
        this.reservationService.deleteReservation(reservationId);
    }
    @DeleteMapping("/reservations/deleteAllToDate/{date}")
    public void deleteAllDueReservations(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        this.reservationService.deleteAllDueReservations(date);
    }
    @GetMapping("/reservations/{reservationId}")
    public Reservation getReservation(@PathVariable Long reservationId){
        return this.reservationService.getReservation(reservationId);
    }
    @GetMapping("/reservations/user/{userEmail}")
    public List<Reservation> findReservationsByUser(@PathVariable String userEmail){
        return this.reservationService.findReservationsByUser(userEmail);
    }
    @GetMapping("/reservations/location/{locationId}")
    public List<Reservation> findReservationsByLocation(@PathVariable Integer locationId){
        return this.reservationService.findReservationsByLocation(locationId);
    }
    @GetMapping("/reservations/date/{date}")
    public List<Reservation> findReservationsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return this.reservationService.findReservationsByDate(date);
    }

// USERS ENDPOINT
    @GetMapping("/users")
    public List<User> findUsers(@RequestParam(name = "email",required = false,defaultValue = "") String email,
                                @RequestParam(name = "name",required = false,defaultValue = "") String name){
        if(email.length()>=1 || name.length()>=1){
            return this.userService.findUsersByEmailOrName(email,name);
        }
        return this.userService.getAllUsers();
    }
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId){
        return this.userService.getUserById(userId);
    }
    @GetMapping("/users/{userEmail}")
    public User getUserByEmail(@PathVariable String userEmail){
        return this.userService.getUserByEmail(userEmail);
    }
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId){
        this.userService.deleteUser(userId);
    }
    @PatchMapping("/users/changePass/{userId}")
    public boolean changeUserPassword(@PathVariable Long userId,
                                      @RequestHeader(name = "password") String password){

        return this.userService.changeUserPassword(userId,password);
    } //Should be encripted or done trough another secured service
    @PatchMapping("users/setRole/{userId}")
    public User setUserRole(@PathVariable Long userId,
                            @RequestParam(name = "role") String role){
        return this.userService.setUserRole(userId,Role.valueOf(role));
    }

}
