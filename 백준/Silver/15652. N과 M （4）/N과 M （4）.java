import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		perm(0);
		System.out.println(sb.toString());
	}

	public static void perm(int dept) {
		// 기저
		if (dept == M) {
			for(int i =0; i <M-1; i++) {
				if(arr[i] > arr[i+1]) {
					return;
				}
			}
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		// 유도

		for (int i = 1; i <= N; i++) {
				arr[dept] = i;
				perm(dept + 1);
		}
	}

}