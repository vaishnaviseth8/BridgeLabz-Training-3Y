package TypesofInheritance;

class Device {
    protected String deviceId;
    protected String status;

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID : " + deviceId);
        System.out.println("Status    : " + status);
    }
}

class Thermostat extends Device {
    private double temperatureSetting;

    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature: " + temperatureSetting + "°C");
        System.out.println("Device Type: Thermostat");
        System.out.println("-----------------------------");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat("TH001", "Online", 22.5);
        Thermostat t2 = new Thermostat("TH002", "Offline", 19.0);

        t1.displayStatus();
        t2.displayStatus();
    }
}

