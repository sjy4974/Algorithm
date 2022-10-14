import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static boolean[] visited;
	static int M,N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visited = new boolean[N+1];
		perm(0);
		System.out.println(sb.toString());
	}
	
	static void perm(int dept) {
		//기저조건
		if(dept == M) {
			for(int i =0; i<arr.length; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		//유도조건
		for(int i = 1; i<=N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[dept] = i;
				perm(dept+1);
				visited[i] = false;
			}
		}
	}
}
