import java.util.Scanner;

public class ExceptionHandling {

    public static double divide(int x, int y) throws ArithmeticException {
        if (y == 0)
            throw new ArithmeticException("Divide by zero");
        return x / y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two numbers: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        try {
            double result = divide(x, y);
            System.out.println(x + " / " + y + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is not possible");
        } finally {
            System.out.println("Operations completed");
        }
    }
}