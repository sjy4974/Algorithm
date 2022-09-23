import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int D, W, K;
	static int[][] map;

	static int min;

	// A:0, B:1
	static int[] layerA, layerB;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[D][W];
			layerA = new int[W];
			layerB = new int[W];

			Arrays.fill(layerB, 1);
			min = Integer.MAX_VALUE;

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 재귀호출
			// 행 0 , 1, 2, ... , D-1

			// 먼저 idx에 작업 수행 후, idx+1번째 작업 호출
			// process (idx)
			// 시작호출: process(0) : 0번 막에 대해 작업 수행 후, 다음 호출
			// process(1) ... process(D-1) 이후 process(D) : idx == D 이므로 종료

			// 각 작업
			// 1. 처리를 안함 : 약품 사용 횟수 증가 x
			// 2. A를 처리 : 약품 사용 횟수 증가
			// 3. B를 처리 : 약품 사용 횟수 증가
			// => 약품 사용 횟수 저장하기 위해 cnt 추가 -> process(idx,cnt);
			// 시작 : process(0, 0)
			// 1. 만약 약품 처리를 안했으면 process(1, 0);
			// 2. A 약품 처리를 안했으면 process(1, 1);
			// 3. B 약품 처리를 안했으면 process(1, 1);

			process(0, 0);

			System.out.println("#" + tc + " " + min);

		}
	}

	public static void process(int idx, int cnt) {
		// TODO Auto-generated method stub
		// 기저 조건
		if (idx == D) {
			if (check()) { // 검사를 통과했다면
				if (cnt < min)
					min = cnt; // 약품처리 최솟값 갱신
			}
			return;
		}

		// min : 임시최적해
		// cnt >= min : 더이상 탐색할 의미가 없음
		if (cnt >= min)
			return;

		// 유도 조건
		// - 3가지 : 처리 x, A 처리, B 처리

		// 지금 현재 idx번째 막의 상태를 임시 저장

		int[] temp = map[idx];

		// 처리 x : 약품처리를 최소로 해야하기 때문에 처리 하지않은걸 먼저 실행
		process(idx + 1, cnt);

		// A처리
		map[idx] = layerA;
		process(idx + 1, cnt + 1);

		// B처리
		map[idx] = layerB;
		process(idx + 1, cnt + 1);

		// 행렬 복원
		map[idx] = temp;
	}

	public static boolean check() {
		// 열을 고정하고 행을 0부터 D-1까지 내려가면서 같은 것의 개수를 셈
		// 같은 것이 연속되는 것이 K개 이상
		for (int c = 0; c < W; c++) {
			int cnt = 1;
			int max = 0;
			for (int r = 0; r < D - 1; r++) {
				if (map[r][c] == map[r + 1][c]) {
					cnt++;
				} else {
					cnt = 1; // r, r+1 다르면 초기화
				}
				// 항상 같은 경우만 있는 게아님.
				if (cnt > max)
					max = cnt; // 최댓값 갱신
			}
			if (max < K)
				return false; // 전체 열중 하나라도 K보다 작은 열이있으면 false;
		}
		return true;
	}

}