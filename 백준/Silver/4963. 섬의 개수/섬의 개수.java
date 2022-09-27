import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0, -1, 1, 1, -1 };
	static int[] dc = { 0, 0, -1, 1, 1, 1, -1, -1 };

	static int w, h;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			visited = new boolean[h][w];
			for (int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			for(int r= 0; r< h; r++) {
				for(int c= 0; c< w; c++) {
					if(map[r][c] == 1 && !visited[r][c]) {
						bfs(r,c);
						cnt++;
					}
				}
			}
			System.out.println(cnt);

		}

	}

	public static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r,c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] rc = queue.poll();
			
			for(int d = 0; d<8; d++) {
				int nr = rc[0] + dr[d];
				int nc = rc[1] + dc[d];
				
				if(nr >= 0 && nc >= 0 && nr < h && nc < w) {
					if(map[nr][nc] == 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.offer(new int[] {nr,nc});
					}
				}
			}
		}
		
	}

}