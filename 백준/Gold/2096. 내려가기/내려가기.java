import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;
	static int[][] dp2;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		map = new int[N][3];
		dp = new int[N][3];
		dp2 = new int[N][3];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		dp2[0][0] = map[0][0];
		dp2[0][1] = map[0][1];
		dp2[0][2] = map[0][2];
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + map[i][0];
			dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + map[i][1];
			dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]) + map[i][2];

			dp2[i][0] = Math.min(dp2[i - 1][0], dp2[i - 1][1]) + map[i][0];
			dp2[i][1] = Math.min(dp2[i - 1][0], Math.min(dp2[i - 1][1], dp2[i - 1][2])) + map[i][1];
			dp2[i][2] = Math.min(dp2[i - 1][1], dp2[i - 1][2]) + map[i][2];

		}

		System.out.println(Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], dp[N - 1][2])) + " "
				+ Math.min(dp2[N - 1][0], Math.min(dp2[N - 1][1], dp2[N - 1][2])));
	}

}