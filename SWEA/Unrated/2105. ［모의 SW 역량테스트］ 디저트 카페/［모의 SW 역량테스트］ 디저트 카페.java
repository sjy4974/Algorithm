import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map;
	static int N;
	static int dr[] = { 1, 1, -1, -1 };
	static int dc[] = { 1, -1, -1, 1 };
	static int max;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			max = -1;
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					dfs(r, c, r, c, 0, 0, new ArrayList<Integer>());
				}
			}
			System.out.println("#" + tc + " " + max);
		}

	}

	public static void dfs(int sr, int sc, int cr, int cc, int d, int cnt, ArrayList<Integer> list) {
		if (sr == cr && sc == cc && d == 3) {
			if(cnt>max) {
				max = cnt;
			}
			return;
		}
		
		//같은방향
		int nr = cr + dr[d];
		int nc = cc + dc[d];

		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			if (!list.contains(map[nr][nc])) {
				list.add(map[nr][nc]);
				dfs(sr, sc, nr, nc, d, cnt + 1, list);
				list.remove(list.size()-1);
			}
		}

		//다른방향
		if (d < 3) {
			nr = cr + dr[d + 1];
			nc = cc + dc[d + 1];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (!list.contains(map[nr][nc])) {
					list.add(map[nr][nc]);
					dfs(sr, sc, nr, nc, d + 1, cnt + 1, list);
					list.remove(list.size()-1);
				}
			}
		}

	}

}