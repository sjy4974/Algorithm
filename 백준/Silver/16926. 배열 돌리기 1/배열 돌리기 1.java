import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N;
	static int M;
	static int R;
	static int C;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		C = Math.min(N, M) / 2;

		for (int i = 0; i < R; i++) {
			rotate();
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}

	}

	private static void rotate() {
		for (int n = 0; n < C; n++) {
			int tmp = map[n][n];

			int d = 0;
			int lr = n, lc = n;
			while (d < 4) {
				int nr = lr + dr[d];
				int nc = lc + dc[d];

				if (nr >= n && nc >= n && nr < M - n && nc < N - n) {
					map[lc][lr] = map[nc][nr]; 
					lr = nr; 
					lc = nc;
				} else {
					d++; 
				}

			}

			map[n + 1][n] = tmp;
		}
	}

}