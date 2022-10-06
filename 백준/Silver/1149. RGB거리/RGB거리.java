import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] memo;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		
		for(int r = 0; r <N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 3; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		memo = new int[N][3];
		memo[0][0] = map[0][0];
		memo[0][1] = map[0][1];
		memo[0][2] = map[0][2];
		
		for(int i =1; i<N; i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2])+map[i][0];
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2])+map[i][1];
			memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1])+map[i][2];
		}
		
		System.out.println(Math.min(memo[N-1][0], Math.min(memo[N-1][1], memo[N-1][2])));
		
	}

}