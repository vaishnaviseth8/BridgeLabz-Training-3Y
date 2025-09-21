package ScenarioBasedQues;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventEaseApp {
    public static void main(String[] args) {
        User organizer = new User("Alice Johnson", "alice@example.com");

        BirthdayEvent birthday = new BirthdayEvent("Alice's Birthday", "Grand Hall", LocalDate.of(2025, 10, 12), organizer, true, false);
        ConferenceEvent conference = new ConferenceEvent("Tech Conference", "Convention Center", LocalDate.of(2025, 11, 5), organizer, true, true);

        birthday.schedule();
        conference.schedule();

        birthday.reschedule(LocalDate.of(2025, 10, 15));

        System.out.println("Birthday Event Cost: $" + birthday.calculateCost());
        System.out.println("Conference Event Cost: $" + conference.calculateCost());

        conference.cancel();
    }
}

interface ISchedulable {
    void schedule();
    void reschedule(LocalDate newDate);
    void cancel();
}

class User {
    private String name;
    private String email;
    private String phoneNumber; // optional sensitive data

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // getters (no setters for sensitive data)
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

abstract class Event implements ISchedulable {
    private static int idCounter = 1000;
    private final int eventId;
    private String eventName;
    private String location;
    private LocalDate date;
    private User organizer;
    private List<String> attendees;
    protected double venueCost;
    protected double cateringCost;
    protected double decorationCost;
    protected double discount;
    private boolean isScheduled;

    public Event(String eventName, String location, LocalDate date, User organizer, boolean catering, boolean decoration) {
        this.eventId = idCounter++;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.organizer = organizer;
        this.attendees = new ArrayList<>();
        this.cateringCost = catering ? 500 : 0;
        this.decorationCost = decoration ? 300 : 0;
        this.venueCost = 1000; // base venue cost for all events
        this.discount = 0;
        this.isScheduled = false;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getOrganizer() {
        return organizer;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public void addAttendee(String attendeeName) {
        attendees.add(attendeeName);
    }

    // Calculate total cost: venue + catering + decoration - discount
    public double calculateCost() {
        return venueCost + cateringCost + decorationCost - discount;
    }

    @Override
    public abstract void schedule();

    @Override
    public void reschedule(LocalDate newDate) {
        if (isScheduled) {
            System.out.println("Rescheduling event from " + date + " to " + newDate);
            this.date = newDate;
        } else {
            System.out.println("Event is not scheduled yet, cannot reschedule.");
        }
    }

    @Override
    public void cancel() {
        if (isScheduled) {
            System.out.println("Event " + eventName + " cancelled.");
            isScheduled = false;
        } else {
            System.out.println("Event is not scheduled yet.");
        }
    }

    protected void setScheduled(boolean scheduled) {
        this.isScheduled = scheduled;
    }
}

class BirthdayEvent extends Event {
    public BirthdayEvent(String eventName, String location, LocalDate date, User organizer, boolean catering, boolean decoration) {
        super(eventName, location, date, organizer, catering, decoration);
        this.discount = 100; // birthday discount
    }

    @Override
    public void schedule() {
        System.out.println("Scheduling birthday event '" + getEventName() + "' on " + getDate());
        setScheduled(true);
    }
}

class ConferenceEvent extends Event {
    public ConferenceEvent(String eventName, String location, LocalDate date, User organizer, boolean catering, boolean decoration) {
        super(eventName, location, date, organizer, catering, decoration);
        this.discount = 200; // conference discount
        this.venueCost = 3000; // higher venue cost for conference
    }

    @Override
    public void schedule() {
        System.out.println("Scheduling conference event '" + getEventName() + "' on " + getDate());
        setScheduled(true);
    }
}

