import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static BigInteger[] memo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new BigInteger[10001];
		Arrays.fill(memo, BigInteger.valueOf(-1));
		memo[0] = BigInteger.valueOf(0);
		memo[1] = BigInteger.valueOf(1);
		System.out.println(fibo(N));
	}

	static BigInteger fibo(int n) {
		if (memo[n].compareTo(BigInteger.valueOf(-1)) == 0)
			memo[n] = fibo(n - 2).add(fibo(n - 1));
		return memo[n];
	}

}