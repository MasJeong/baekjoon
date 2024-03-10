import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int maxIdx = 0;
		sc.close();
		int max = 0;
		
		if (num1 > num2)
			max = num1;
		else
			max = num2;

		for (int i = 1; i <= max; i++) {
			if ((num1 % i == 0) && (num2 % i == 0))
				maxIdx = i;
		}
		System.out.println(maxIdx);
		System.out.println(num1 * num2 / maxIdx);

	}
}