package Inheritance;

public class Vehicle {
    static double registrationFee = 5000.00;

    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: ₹" + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Vaishnavi", "Car", "MH12AB1234");
        Vehicle v2 = new Vehicle("Arjun", "Bike", "MH14XY5678");

        v1.displayRegistrationDetails();
        v2.displayRegistrationDetails();

        Vehicle.updateRegistrationFee(6000.00);

        System.out.println("\nAfter updating registration fee:\n");

        v1.displayRegistrationDetails();
        v2.displayRegistrationDetails();
    }
}

