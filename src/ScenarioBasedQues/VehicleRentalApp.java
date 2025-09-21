package ScenarioBasedQues;

public class VehicleRentalApp {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice Johnson", "alice@example.com");

        Bike bike = new Bike("Yamaha MT-15", 15);
        Car car = new Car("Honda Civic", 50, 5);
        Truck truck = new Truck("Volvo Truck", 100, 20);

        System.out.println("Bike rent for 3 days: $" + bike.calculateRent(3));
        System.out.println("Car rent for 5 days: $" + car.calculateRent(5));
        System.out.println("Truck rent for 2 days: $" + truck.calculateRent(2));
    }
}

interface Rentable {
    double calculateRent(int days);
}

class Vehicle {
    protected String model;
    protected double baseRate;  // base rental rate per day

    public Vehicle(String model, double baseRate) {
        this.model = model;
        this.baseRate = baseRate;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRate() {
        return baseRate;
    }
}

class Bike extends Vehicle implements Rentable {
    public Bike(String model, double baseRate) {
        super(model, baseRate);
    }

    @Override
    public double calculateRent(int days) {
        double total = baseRate * days;
        if (days > 5) {
            total *= 0.9; // 10% discount for rentals longer than 5 days
        }
        return total;
    }
}

class Car extends Vehicle implements Rentable {
    private int seatingCapacity;

    public Car(String model, double baseRate, int seatingCapacity) {
        super(model, baseRate);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    @Override
    public double calculateRent(int days) {
        double surcharge = seatingCapacity > 5 ? 20 : 0;
        return (baseRate * days) + surcharge;
    }
}

class Truck extends Vehicle implements Rentable {
    private double loadCapacity;  // in tons

    public Truck(String model, double baseRate, double loadCapacity) {
        super(model, baseRate);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public double calculateRent(int days) {
        double surcharge = loadCapacity * 10; // surcharge per day based on capacity
        return (baseRate * days) + (surcharge * days);
    }
}

class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

