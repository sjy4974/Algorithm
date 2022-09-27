import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int max;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			max = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int day = 0;
			while (day <= 100) {
				int cnt = 0;
				visited = new boolean[N][N];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (!visited[r][c] && map[r][c] > day) {
							dfs(r, c, day);
							cnt++;
						}
					}
				}
				if (cnt > max) {
					max = cnt;
				}
				day++;
			}
			System.out.println("#" + tc + " " + max);

		}

	}

	private static void dfs(int r, int c, int day) {
		// TODO Auto-generated method stub
		visited[r][c] = true;
		
		for(int d= 0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr >= 0 && nc >=0 && nr<N && nc<N) {
				if(map[nr][nc] > day && !visited[nr][nc]) {
					dfs(nr,nc,day);
				}
			}
		}
		
	}
}