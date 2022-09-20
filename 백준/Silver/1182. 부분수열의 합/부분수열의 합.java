import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,S,ans;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		powerSet(0);
		if(S == 0) {
			ans--;
		}
		System.out.println(ans);
	}
	
	public static void powerSet(int idx) {
		if (idx == N) {
			int sum = 0;
			for(int i =0; i < N ; i++) {
				if(visited[i]) {
					sum += arr[i];
				}
			}
			
			if(sum == S) {
				ans++;
			}
			
			return;
		}
		visited[idx] = true;
		powerSet(idx+1);
		visited[idx] = false;
		powerSet(idx+1);
	}

}