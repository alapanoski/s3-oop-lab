import java.util.Scanner;
import java.util.StringTokenizer;

public class AddIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a line of some integers: ");
        StringTokenizer integers = new StringTokenizer(scanner.nextLine());

        int sum = 0;
        while (integers.hasMoreTokens()) {
            int i = Integer.parseInt(integers.nextToken());
            System.out.println(i);
            sum += i;
        }

        System.out.println("Sum of the above integers = " + sum);
    }
}