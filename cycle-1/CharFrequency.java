import java.util.Scanner;

public class CharFrequency {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String str;
		char ch;
		int freq = 0;

		System.out.println("Enter a string: ");
		str = scanner.nextLine();

		System.out.println("Enter a character: ");
		ch = scanner.next().charAt(0);

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch)
				freq++;
		}

		System.out.println("Frequency of " + ch + " is " + freq);
	}
}
