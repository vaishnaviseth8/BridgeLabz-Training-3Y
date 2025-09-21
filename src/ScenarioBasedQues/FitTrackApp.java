package ScenarioBasedQues;

import java.util.*;

public class FitTrackApp {
    public static void main(String[] args) {
        UserProfile user = new UserProfile("John Doe", 30, 75.0, 2500);

        Workout cardio = new CardioWorkout("Running", 30);
        Workout strength = new StrengthWorkout("Weight Lifting", 45);

        user.startWorkout(cardio);
        user.stopWorkout(cardio);

        user.startWorkout(strength);
        user.stopWorkout(strength);

        System.out.println("User: " + user.getName());
        System.out.println("Daily Calorie Goal: " + user.getGoal());
        System.out.println("Calories burned cardio: " + cardio.calculateCalories());
        System.out.println("Calories burned strength: " + strength.calculateCalories());
        System.out.println("Remaining calories for the day: " + (user.getGoal() - (cardio.calculateCalories() + strength.calculateCalories())));
    }
}

interface ITrackable {
    void startWorkout();
    void stopWorkout();
}

class UserProfile implements ITrackable {
    private String name;
    private int age;
    private double weight;
    private int goal; // daily calorie goal
    private boolean workoutActive;

    public UserProfile(String name, int age, double weight, int goal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = goal;
        this.workoutActive = false;
    }

    public UserProfile(String name, int age, double weight) {
        this(name, age, weight, 2000); // default goal if not provided
    }

    public String getName() {
        return name;
    }

    public int getGoal() {
        return goal;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public void startWorkout() {
        workoutActive = true;
        System.out.println("Workout started.");
    }

    @Override
    public void stopWorkout() {
        workoutActive = false;
        System.out.println("Workout stopped.");
    }

    // Overloaded methods to work with Workout
    public void startWorkout(Workout workout) {
        workout.startWorkout();
    }

    public void stopWorkout(Workout workout) {
        workout.stopWorkout();
    }
}

abstract class Workout implements ITrackable {
    protected String type;
    protected int duration; // in minutes
    protected int caloriesBurned;
    protected boolean isActive;

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = 0;
        this.isActive = false;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public abstract int calculateCalories();

    @Override
    public void startWorkout() {
        isActive = true;
        System.out.println(type + " workout started.");
    }

    @Override
    public void stopWorkout() {
        isActive = false;
        caloriesBurned = calculateCalories();
        System.out.println(type + " workout stopped. Calories burned: " + caloriesBurned);
    }
}

class CardioWorkout extends Workout {
    public CardioWorkout(String type, int duration) {
        super(type, duration);
    }

    @Override
    public int calculateCalories() {
        // For example, cardio burns 10 calories per minute
        return duration * 10;
    }
}

class StrengthWorkout extends Workout {
    public StrengthWorkout(String type, int duration) {
        super(type, duration);
    }

    @Override
    public int calculateCalories() {
        // Strength training burns 8 calories per minute
        return duration * 8;
    }
}

