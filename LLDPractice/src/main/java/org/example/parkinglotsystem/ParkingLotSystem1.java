package org.example.parkinglotsystem;
import java.util.*;

enum VehicleType {
    MOTORCYCLE("Motorcycle"),
    CAR("Car"),
    BUS("Bus");

    private final String value;

    VehicleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

enum SpotSize {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String value;

    SpotSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate(){
        return licensePlate;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }
}

class ParkingSpot {
    private String spotId;
    private SpotSize size;
    private Vehicle vehicle;

    public ParkingSpot(String spotId, SpotSize size) {
        this.spotId = spotId;
        this.size = size;
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {

        VehicleType type = vehicle.getVehicleType();

        if(size == SpotSize.SMALL && type == VehicleType.MOTORCYCLE)
            return true;
        if(size == SpotSize.MEDIUM && type == VehicleType.CAR)
            return true;
        if(size == SpotSize.LARGE && type == VehicleType.BUS)
            return true;

        return false;

    }

    public boolean parkVehicle(Vehicle vehicle) {

        if(isAvailable() && canFitVehicle(vehicle)) {
            this.vehicle = vehicle;
            return true;
        }
        return false;
    }

    public Vehicle removeVehicle() {

        if(vehicle == null) return null;

        Vehicle v = this.vehicle;
        this.vehicle = null;
        return v;
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotSize getSize() {
        return size;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

class ParkingLevel {
    private String levelId;
    private int numSpots;
    private List<ParkingSpot> spots;

    public ParkingLevel(String levelId, int numSpots) {

        this.levelId = levelId;
        this.numSpots = numSpots;
        this.spots = new ArrayList<>();
        initializeSpots(numSpots);
    }

    private void initializeSpots(int numSpots) {
        int numSmall = (int)(0.2*numSpots);
        int numMedium = (int)(0.5*numSpots);
        int numLarge = numSpots - numSmall - numMedium;
        int idx = 1;

        for(int i = 0; i<numSmall; i++){
            spots.add(new ParkingSpot(levelId + "_SPOT_" + idx, SpotSize.SMALL));
            idx++;
        }
        for(int i = 0; i<numMedium; i++){
            spots.add(new ParkingSpot(levelId + "_SPOT_" + idx, SpotSize.MEDIUM));
            idx++;
        }
        for(int i = 0; i<numLarge; i++){
            spots.add(new ParkingSpot(levelId + "_SPOT_" + idx, SpotSize.LARGE));
            idx++;
        }
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        ParkingSpot avl = null;

        for(ParkingSpot spot:spots){

            if(spot.isAvailable() && spot.canFitVehicle(vehicle)){
                avl = spot;
                break;
            }
        }
        return avl;
    }

    public int getAvailableSpotsCount(VehicleType vehicleType) {

        int cnt = 0;
        Vehicle v = new Vehicle("1xxx", vehicleType);

        for(ParkingSpot spot:spots){
            if(spot.isAvailable() && spot.canFitVehicle(v)){
                cnt++;
            }
        }

        return cnt;
    }
}

class ParkingLot {
    private String name;
    private int numLevels;
    private int spotsPerLevel;
    private List<ParkingLevel> levels;
    private Map<String,ParkingSpot> spotMap;

    public ParkingLot(int numLevels, int spotsPerLevel) {
        this("DefaultLot", numLevels, spotsPerLevel);
    }

    public ParkingLot(String name, int numLevels, int spotsPerLevel) {
        this.name = name;
        this.numLevels = numLevels;
        this.spotsPerLevel = spotsPerLevel;

        levels = new ArrayList<>();
        int l = 101;

        for(int i = 0; i<numLevels; i++){
            levels.add(new ParkingLevel("level_" + i + 1, spotsPerLevel));
            l++;
        }
        this.spotMap = new HashMap<>();
    }

    public boolean parkVehicle(Vehicle vehicle) {

        if(spotMap.containsKey(vehicle.getLicensePlate())) return false;

        for(ParkingLevel level:levels){
            ParkingSpot spot = level.findAvailableSpot(vehicle);
            if(spot != null){
                spotMap.put(vehicle.getLicensePlate(), spot);
                spot.parkVehicle(vehicle);
                return true;
            }
        }

        return false;
    }

    public boolean removeVehicle(String licensePlate) {
        if(!spotMap.containsKey(licensePlate)) return false;

        ParkingSpot spot = spotMap.get(licensePlate);
        spotMap.remove(licensePlate);

        spot.removeVehicle();
        return true;
    }

    public int getAvailableSpots(VehicleType vehicleType) {

        int cnt = 0;
        for(ParkingLevel level:levels){
            cnt += level.getAvailableSpotsCount(vehicleType);
        }

        return cnt;
    }
}

// Your code will be instantiated and invoked as follows:
// Vehicle vCar = new Vehicle("C123", VehicleType.CAR);
// Vehicle vBus = new Vehicle("B999", VehicleType.BUS);
// Vehicle vMoto = new Vehicle("M001", VehicleType.MOTORCYCLE);
// ParkingLot lot = new ParkingLot("Main Lot", 2, 10);
// lot.parkVehicle(vCar);
// lot.parkVehicle(vBus);
// lot.getAvailableSpots(VehicleType.MOTORCYCLE);
// lot.parkVehicle(vMoto);
// lot.removeVehicle("C123");
// lot.getAvailableSpots(VehicleType.CAR);

public class ParkingLotSystem1 {
}
