package Control_flow;
import java.util.Scanner;

public class Divisibility {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                // Input the number
                System.out.print("Enter a number: ");
                int num = sc.nextInt();

                // Check divisibility
                if (num % 5 == 0) {
                    System.out.println(num + " is divisible by 5.");
                } else {
                    System.out.println(num + " is NOT divisible by 5.");
                }

                sc.close();
    }
}

