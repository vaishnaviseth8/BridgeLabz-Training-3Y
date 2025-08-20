package programming_elements;

public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result);

        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2);

        int a = 5, b = 10, c = 2;
        int result3 = a + b * c / a;
        System.out.println("a + b * c / a = " + result3);
    }
}

