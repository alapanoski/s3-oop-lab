import java.util.Scanner;

public class BinarySearch {
	public static void sort(String[] a, int[] ia) {
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a.length - 1; j++)
				if (a[j].compareTo(a[j + 1]) > 0) {
					String temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					int tempIndex = ia[j];
					ia[j] = ia[j + 1];
					ia[j + 1] = tempIndex;
				}
	}

	public static int binarySearch(String a[], String x, int l, int r) {
		if (!(l < r))
			return -1;
		int m = (l + r) / 2;
		if (a[m].equals(x))
			return m;
		else if (x.compareTo(a[m]) < 0)
			return binarySearch(a, x, l, m);
		else if (x.compareTo(a[m]) > 0)
			return binarySearch(a, x, m, r);
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of the array: ");
		int size = scanner.nextInt();

		String[] a = new String[size];
		int[] ia = new int[size];
		for (int i = 0; i < size; i++)
			ia[i] = i;

		System.out.println("Enter the elements: ");
		for (int i = 0; i < size; i++)
			a[i] = scanner.next();

		sort(a, ia);
		
		for (int i = 0; i < size; i++)
			System.out.print(a[i] + " ");
		System.out.println();

		System.out.println("Enter value to search for: ");
		String x = scanner.next();

		int foundAt = binarySearch(a, x, 0, size - 1);

		if (foundAt == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element found at " + ia[foundAt]);

	}
}
