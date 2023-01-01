import java.util.Scanner;

public class QuickSort {
	public static void quickSort(String a[], int l, int r) {
		if (l < r) {
			int pivot = partition(a, l, r);
			quickSort(a, l, pivot - 1);
			quickSort(a, pivot + 1, r);
		}
	}

	public static int partition(String a[], int l, int r) {
		String pivot = a[r];
		int i = l - 1;
		for (int j = l; j <= r; j++) {
			if (a[j].compareTo(pivot) < 0) {
				i++;
				String temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		String temp = a[i + 1];
		a[i + 1] = a[r];
		a[r] = temp;
		return (i + 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of the array: ");
		int size = scanner.nextInt();

		String[] a = new String[size];

		System.out.println("Enter the elements: ");
		for (int i = 0; i < size; i++)
			a[i] = scanner.next();

		quickSort(a, 0, a.length - 1);

		for (int i = 0; i < size; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
}
