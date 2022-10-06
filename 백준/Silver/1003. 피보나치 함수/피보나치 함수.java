import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[][] memo;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <=T; tc++) {
			N = Integer.parseInt(br.readLine());
			memo = new int[N+1][2];
			for(int i =0; i<=N; i++) {
				if(i == 0) {
					memo[i][0] = 1;
					memo[i][1] = 0;
				} else if( i == 1) {
					memo[i][0] = 0;
					memo[i][1] = 1;
		
				} else {
					memo[i][0] = memo[i-2][0]+memo[i-1][0];
					memo[i][1] = memo[i-2][1]+memo[i-1][1];
				}
			}
			System.out.printf("%d %d\n",memo[N][0],memo[N][1]);
			
		}
	}


}