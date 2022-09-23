import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] map;
	static ArrayList<int[]> cores;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int maxCnt; // 최대 연결갯수
	static int minLength; // 최소 연결 길이

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cores = new ArrayList<>();

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] == 1 && r != 0 && r != N - 1 && c != 0 && c != N - 1) {
						cores.add(new int[] { r, c }); // 코어의 좌표 저장
					}
				}
			}

			maxCnt = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;

			linkCore(0, 0);
			
			System.out.println("#"+tc+" "+minLength);
		}
	}

	public static void linkCore(int idx, int cnt) {
		// 기저 조건
		if (idx == cores.size()) {
			int length = wireLength();
			// 최대 연결수 발견시, 업데이트
			if(cnt > maxCnt) {
				maxCnt = cnt;
				minLength = length;
			}
			// 연결수가 같으면, 더 작은 길이로 갱신
			if( cnt == maxCnt) {
				if(length < minLength) {
					minLength = length;
				}
			}
			return;
		}

		// 유도 조건
		// 연결 않하고x, 상하좌우
		linkCore(idx + 1, cnt);

		int[] core = cores.get(idx);
		int r = core[0];
		int c = core[1];

		for (int d = 0; d < 4; d++) {
			if (check(r, c, d)) {
				linkWire(r, c, d, 2);
				
				linkCore(idx + 1, cnt + 1);

				// 초기화
				linkWire(r, c, d, 0);
			}
		}
	}

	public static int wireLength() {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int r= 0; r < N; r++) {
			for(int c= 0; c<N; c++) {
				if(map[r][c] == 2) cnt++;
			}
		}
		return cnt;
	}

	public static void linkWire(int r, int c, int d, int n) {
		// TODO Auto-generated method stub
		int nr = r + dr[d];
		int nc = c + dc[d];

		while (true) {
			if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1)
				break;

			map[nr][nc] = n;

			nr += dr[d];
			nc += dc[d];
		}

	}

	public static boolean check(int r, int c, int d) {
		// TODO Auto-generated method stub
		int nr = r + dr[d];
		int nc = c + dc[d];
		while (true) {
			if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1)
				break;
			if (map[nr][nc] != 0)
				return false;

			nr += dr[d];
			nc += dc[d];
		}
		return true;
	}
}