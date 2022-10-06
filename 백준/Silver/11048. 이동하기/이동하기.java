import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] dp = new int[N][M];
		
		for(int r = 0; r< N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c <M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = map[0][0];
		for(int r = 0; r<N; r++) {
			for(int c = 0; c <M; c++) {
				if (r == 0 && c == 0) continue;
				if ( r != 0 && c == 0 ) {
					dp[r][c] = dp[r-1][c]+map[r][c];
					continue;
				} 
				if ( r == 0 && c != 0 ) {
					dp[r][c] = dp[0][c-1]+map[r][c];
					continue;
				}
				dp[r][c] = Math.max(dp[r-1][c], Math.max(dp[r][c-1], dp[r-1][c-1]))+map[r][c];
			}
		}
		System.out.println(dp[N-1][M-1]);
		
	}
}