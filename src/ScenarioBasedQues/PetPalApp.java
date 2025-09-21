package ScenarioBasedQues;

import java.util.Random;

public class PetPalApp {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3);
        Cat cat = new Cat("Whiskers", 2);
        Bird bird = new Bird("Tweety", 1);

        dog.feed();
        dog.play();
        dog.sleep();
        dog.makeSound();

        cat.feed();
        cat.play();
        cat.sleep();
        cat.makeSound();

        bird.feed();
        bird.play();
        bird.sleep();
        bird.makeSound();
    }
}

interface IInteractable {
    void feed();
    void play();
    void sleep();
}

abstract class Pet implements IInteractable {
    private String name;
    private String type;
    private int age;
    private int hunger; // 0 (full) to 100 (starving)
    private int mood;   // 0 (sad) to 100 (happy)
    private int energy; // 0 (tired) to 100 (energetic)
    private Random rand = new Random();

    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.hunger = rand.nextInt(50);  // random default hunger 0-49
        this.mood = rand.nextInt(50) + 50; // random default mood 50-99
        this.energy = rand.nextInt(50) + 50; // random default energy 50-99
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public int getHunger() {
        return hunger;
    }

    public int getMood() {
        return mood;
    }

    public int getEnergy() {
        return energy;
    }

    // Encapsulated setters for hunger and mood to control changes internally
    private void changeHunger(int amount) {
        hunger += amount;
        if (hunger < 0) hunger = 0;
        if (hunger > 100) hunger = 100;
    }

    private void changeMood(int amount) {
        mood += amount;
        if (mood < 0) mood = 0;
        if (mood > 100) mood = 100;
    }

    private void changeEnergy(int amount) {
        energy += amount;
        if (energy < 0) energy = 0;
        if (energy > 100) energy = 100;
    }

    @Override
    public void feed() {
        System.out.println(name + " is being fed.");
        changeHunger(-30);
        changeMood(10);
        changeEnergy(5);
        printStatus();
    }

    @Override
    public void play() {
        System.out.println(name + " is playing.");
        changeHunger(20);
        changeMood(20);
        changeEnergy(-30);
        printStatus();
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping.");
        changeHunger(10);
        changeMood(15);
        changeEnergy(40);
        printStatus();
    }

    public abstract void makeSound();

    protected void printStatus() {
        System.out.println(name + "'s hunger: " + hunger + ", mood: " + mood + ", energy: " + energy);
    }
}

class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, "Dog", age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof Woof!");
    }
}

class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, "Cat", age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }
}

class Bird extends Pet {
    public Bird(String name, int age) {
        super(name, "Bird", age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Tweet Tweet!");
    }
}

