package ScenarioBasedQues;

public class CabbyGoApp {
    public static void main(String[] args) {
        Driver driver1 = new Driver("Alice Johnson", "LIC12345", 4.8);
        Vehicle miniCar = new Mini("MH12AB1234", 4);
        Vehicle sedanCar = new Sedan("MH12CD5678", 4);
        Vehicle suvCar = new SUV("MH12EF9012", 6);

        IRideService rideServiceMini = new RideService(miniCar, driver1);
        IRideService rideServiceSedan = new RideService(sedanCar, driver1);
        IRideService rideServiceSUV = new RideService(suvCar, driver1);

        rideServiceMini.bookRide(10);  // distance 10 km
        System.out.println("Fare for Mini: " + rideServiceMini.getFare());

        rideServiceSedan.bookRide(15);
        System.out.println("Fare for Sedan: " + rideServiceSedan.getFare());

        rideServiceSUV.bookRide(20);
        System.out.println("Fare for SUV: " + rideServiceSUV.getFare());

        rideServiceMini.endRide();
        rideServiceSedan.endRide();
        rideServiceSUV.endRide();
    }
}

interface IRideService {
    void bookRide(double distance);
    void endRide();
    double getFare();
}

abstract class Vehicle {
    protected String vehicleNumber;
    protected int capacity;
    protected String type;

    public Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFare(double distance);
}

class Mini extends Vehicle {
    private final double baseFare = 30;
    private final double ratePerKm = 10;

    public Mini(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Mini");
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + distance * ratePerKm;
    }
}

class Sedan extends Vehicle {
    private final double baseFare = 50;
    private final double ratePerKm = 15;

    public Sedan(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Sedan");
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + distance * ratePerKm;
    }
}

class SUV extends Vehicle {
    private final double baseFare = 80;
    private final double ratePerKm = 20;

    public SUV(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "SUV");
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + distance * ratePerKm;
    }
}

class Driver {
    private String name;
    private String licenseNumber;
    private double rating;  // private sensitive data

    public Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public double getRating() {
        return rating;
    }
}

class RideService implements IRideService {
    private Vehicle vehicle;
    private Driver driver;
    private double distance;
    private double fare;
    private String location;  // sensitive, kept private

    public RideService(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
        this.distance = 0;
        this.fare = 0;
        this.location = "Unknown";
    }

    @Override
    public void bookRide(double distance) {
        this.distance = distance;
        this.fare = vehicle.calculateFare(distance);
        System.out.println("Ride booked with " + vehicle.getType() + " driven by " + driver.getName() +
                " for distance " + distance + " km");
    }

    @Override
    public void endRide() {
        System.out.println("Ride ended. Total fare: " + fare);
        this.distance = 0;
        this.fare = 0;
        this.location = "Unknown";
    }

    @Override
    public double getFare() {
        return fare;
    }
}

