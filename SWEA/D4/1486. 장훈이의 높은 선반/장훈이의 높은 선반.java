import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, B;
	static int[] arr;
	static boolean[] check;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc<= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr = new int[N];
			check = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = Integer.MAX_VALUE;
			powerSet(0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static void powerSet(int idx) {
		if(idx == N) {
			int sum = 0;
			boolean c = false;
			for(int i = 0; i<N; i++) {
				if(check[i]) {
					c = true;
					sum += arr[i];
				}
			}
			if(!c) return;
			
			int temp = sum - B;
			if(temp < 0) return;
			
			if (temp == 0) {
				ans = temp;
			} else if (temp < ans) ans = temp;
			return;
		} else {
			check[idx] = true;
			powerSet(idx+1);
			check[idx] = false;
			powerSet(idx+1);
		}
		
	}

}