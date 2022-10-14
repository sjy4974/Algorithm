import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static int N, M;
	static LinkedHashSet<String> hs = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		comb(0,0,"");

		for(String s : hs) {
			System.out.println(s);
		}
	}

	public static void comb(int idx,int dept,String str) {
		// 기저
		if (dept == M) {
			hs.add(str);
			return;
		}
		for(int i = idx; i <N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[dept] = arr[i];
				comb(i+1,dept+1,str+result[dept]+" ");
				visited[i] = false;
			}
		}

	}

}