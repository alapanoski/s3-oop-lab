import java.util.Scanner;

public class StringPalindrome {

   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

	String str, revStr = "";

	System.out.println("Enter string: ");
	str = scanner.next();

	for(int i = 0; i < str.length(); i++)
		revStr = str.charAt(i) + revStr;

	if(str.equals(revStr))
		System.out.println("Palindrome");
	else
		System.out.println("Not palindrome");
   }
}
