package TypesofInheritance;

interface Fuelable {
    void refuel();
}

class Auto {
    protected int topSpeed;
    protected String brand;

    public Auto(int topSpeed, String brand) {
        this.topSpeed = topSpeed;
        this.brand = brand;
    }

    public void showDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Top Speed: " + topSpeed + " km/h");
    }
}

class ElectricAuto extends Auto {
    public ElectricAuto(int topSpeed, String brand) {
        super(topSpeed, brand);
    }

    public void chargeBattery() {
        System.out.println(brand + " is charging.");
    }
}

class GasolineAuto extends Auto implements Fuelable {
    public GasolineAuto(int topSpeed, String brand) {
        super(topSpeed, brand);
    }

    @Override
    public void refuel() {
        System.out.println(brand + " is refueling with gasoline.");
    }
}

class AutoManagementSystem {
    public static void main(String[] args) {
        ElectricAuto electricCar = new ElectricAuto(140, "Nissan Leaf");
        GasolineAuto petrolCar = new GasolineAuto(200, "BMW M5");

        electricCar.showDetails();
        electricCar.chargeBattery();

        System.out.println();

        petrolCar.showDetails();
        petrolCar.refuel();
    }
}

