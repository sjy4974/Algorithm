import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[] memo;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		memo = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				memo[1] = arr[0];
			} else if (i == 2) {
				memo[2] = memo[1]+arr[1];
			} else if (i == 3) {
				memo[3] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
			} else {
				memo[i] = Math.max(memo[i - 2] + arr[i - 1], memo[i - 3] + arr[i - 2] + arr[i - 1]);
			}
		}
		System.out.println(memo[N]);
	}

}