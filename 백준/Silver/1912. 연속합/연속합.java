import java.util.Scanner;

public class Main {

	static int[] arr;
	static int[] dp;
	static int max;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[0] = arr[0];
		max = dp[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			if (dp[i] > max) {
				max = dp[i];
			}
		}

		System.out.println(max);
	}

}