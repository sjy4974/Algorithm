import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static long[] memo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new long[10001];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
		System.out.println(fibo(N));
	}

	static long fibo(int n) {
		if (memo[n] == -1)
			memo[n] = fibo(n - 2) + fibo(n - 1);
		return memo[n];
	}

}