import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, W, H, min;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];

			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			drop(0, map);
			
			System.out.println("#"+tc+" "+min);

		}

	}

	private static void drop(int idx, int[][] map) {
		if (idx == N) {
			int cnt = count(map);
			if(cnt < min) min = cnt;
			return;
		}

		for (int c = 0; c < W; c++) {

			int r = 0;
			while (r < H && map[r][c] == 0)
				r++;

			if (r == H) {
				drop(idx + 1, map);
			} else {
				int[][] newMap = new int[H][W];
				// 벽돌복사
				copy(map, newMap);

				// 벽돌깨기
				dfs(newMap, r, c, map[r][c]);

				// 깨고난후 벽돌 내리기
				down(newMap);

				// 다음 구슬던지기
				drop(idx + 1, newMap);
				
				
			}
		}

	}

	private static void down(int[][] map) {
		// 배열 복사용 리스트 만듬
		ArrayList<Integer> list = new ArrayList<>();
		for (int c = 0; c < W; c++) {
			for (int r = H - 1; r >= 0; r--) {
				if (map[r][c] > 0) {
					list.add(map[r][c]);
					map[r][c] = 0;
				}
			}
			// 리스트의 가장 아래부터 채우기
			int r = H - 1;
			for (int i : list)
				map[r--][c] = i;
			list.clear();

		}
	}

	private static void dfs(int[][] map, int r, int c, int cnt) {
		map[r][c] = 0;
		if (cnt == 1)
			return;

		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			for (int k = 1; k < cnt; k++) {
				nr += dr[d];
				nc += dc[d];
				if (nr >= 0 && nc >= 0 && nr < H && nc < W) {
					if (map[nr][nc] != 0) {
						dfs(map, nr, nc, map[nr][nc]);
					}
				}
			}
		}

	}

	public static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}
	
	//개수 세기
	public static int count(int[][] map) {
		int cnt = 0;
		for(int r=0; r<H; r++) {
			for(int c=0; c<W; c++) {
				if(map[r][c] != 0 ) cnt++;
			}
		}
		return cnt;
	}

}