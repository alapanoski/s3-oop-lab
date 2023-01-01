import java.util.Scanner;

public class MatrixMultiplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int m1, n1, m2, n2;

		System.out.println("Enter the dimensions of matrix 1: ");
		m1 = scanner.nextInt();
		n1 = scanner.nextInt();

		int[][] a = new int[m1][n1];

		System.out.println("Enter the elements of matrix 1: ");
		for (int i = 0; i < m1; i++)
			for (int j = 0; j < n1; j++)
				a[i][j] = scanner.nextInt();

		System.out.println("Enter the dimensions of matrix 2: ");
		m2 = scanner.nextInt();
		n2 = scanner.nextInt();

		int[][] b = new int[m2][n2];

		System.out.println("Enter the elements of matrix 2: ");
		for (int i = 0; i < m2; i++)
			for (int j = 0; j < n2; j++)
				b[i][j] = scanner.nextInt();

		if (n1 != m2) {
			System.out.println("Incompatiable matrices");
			return;
		}

		int[][] c = new int[m1][n2];

		for (int i = 0; i < m1; i++)
			for (int j = 0; j < n2; j++)
				for (int k = 0; k < m2; k++)
					c[i][j] += a[i][k] * b[k][j];

		System.out.println("Product is");
		for (int i = 0; i < m1; i++) {
			for (int j = 0; j < n2; j++)
				System.out.print(c[i][j] + " ");
			System.out.println();
		}
	}
}
