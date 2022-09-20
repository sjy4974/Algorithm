import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N;
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 1, 0 };
	static int position = 0;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		powerset(0,1);
		System.out.println(cnt);
	}

	static void powerset(int r, int c) {
		if(r == N-1 && c == N-1) {
			cnt++;
			return;
		}
		else {
			for(int d = 0; d < 3; d++) {
				if(position == 0 && d == 2) continue;
				if(position == 1 && d == 0) continue;
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr < N && nc <N) {
					if( d == 0) {
						if(map[nr][nc] == 1) continue;
						int temp = position;
						position = 0;
						powerset(nr,nc);
						position = temp;
					} else if (d == 1) {
						if(map[nr][nc] == 1 || (nr-1 >= 0 && map[nr-1][nc] == 1) || (nc-1 >= 0 && map[nr][nc-1] == 1)) continue;
						int temp = position;
						position = 2;
						powerset(nr,nc);
						position = temp;
					} else if (d == 2) {
						if(map[nr][nc] == 1) continue;
						int temp = position;
						position = 1;
						powerset(nr,nc);
						position = temp;
					}
				}
			}
		}

	}

}