package ScenarioBasedQues;

public class SmartHomeApp {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room Light", 60);
        Fan ceilingFan = new Fan("Ceiling Fan", 75);
        AC bedroomAC = new AC("Bedroom AC", 1500);

        UserController controller = new UserController();

        controller.controlAppliance(livingRoomLight);
        controller.controlAppliance(ceilingFan);
        controller.controlAppliance(bedroomAC);

        // Compare energy usage between devices
        System.out.println("Is Living Room Light using less power than Ceiling Fan? " + (livingRoomLight.getPower() < ceilingFan.getPower()));
        System.out.println("Does Bedroom AC use equal power as Ceiling Fan? " + (bedroomAC.getPower() == ceilingFan.getPower()));
    }
}

interface Controllable {
    void turnOn();
    void turnOff();
}

abstract class Appliance implements Controllable {
    private String name;
    private int power; // power consumption in watts
    private boolean isOn;

    public Appliance(String name, int power) {
        this.name = name;
        this.power = power;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public boolean isOn() {
        return isOn;
    }

    protected void setOn(boolean on) {
        isOn = on;
    }

    public abstract void turnOn();
    public abstract void turnOff();

    public String getStatus() {
        return name + " is " + (isOn ? "ON" : "OFF") + " with power consumption " + power + "W";
    }
}

class Light extends Appliance {
    public Light(String name, int power) {
        super(name, power);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " turned ON with brightness at 70%");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " turned OFF");
    }
}

class Fan extends Appliance {
    public Fan(String name, int power) {
        super(name, power);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " turned ON at speed level 3");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " turned OFF");
    }
}

class AC extends Appliance {
    public AC(String name, int power) {
        super(name, power);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(getName() + " turned ON with temperature set to 22°C");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(getName() + " turned OFF");
    }
}

class UserController {
    public void controlAppliance(Controllable appliance) {
        appliance.turnOn();
        // Simulate some delay or usage
        appliance.turnOff();
    }
}

