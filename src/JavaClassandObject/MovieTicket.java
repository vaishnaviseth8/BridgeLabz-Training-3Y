package JavaClassandObject;

public class MovieTicket {
    String movieName;
    String seatNumber;
    double price;

    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = null;
        this.price = 0.0;
    }

    public void bookTicket(String seat, double price) {
        this.seatNumber = seat;
        this.price = price;
        System.out.println("Ticket booked successfully.");
    }

    public void displayDetails() {
        System.out.println("Movie Ticket Details:");
        System.out.println("Movie Name : " + movieName);
        if (seatNumber != null) {
            System.out.println("Seat Number: " + seatNumber);
            System.out.printf("Price      : $%.2f\n", price);
        } else {
            System.out.println("No ticket booked yet.");
        }
    }


    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Inception");
        ticket.displayDetails();

        ticket.bookTicket("A12", 12.50);
        ticket.displayDetails();
    }
}

