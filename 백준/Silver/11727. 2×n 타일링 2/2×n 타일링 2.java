import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] memo;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		memo = new int[1001];
		memo[1] = 1;
		memo[2] = 3;
		System.out.println(dp(n));

	}

	public static int dp(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		else if (n == 2) {
			return 3;
		}
		if(memo[n] != 0) {
			return memo[n];
		}
		memo[n] = (dp(n - 1) + 2 * dp(n - 2))%10007;
		return memo[n];
	}

}