import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] memo;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			memo = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				if(i == 1) {
					memo[1] = 1;
				} else if( i == 2) {
					memo[2] = 2;
				} else if (i == 3) {
					memo[3] = 4;
				} else {
					memo[i] = memo[i-1]+memo[i-2]+memo[i-3];
				}
			}
			
			System.out.println(memo[N]);

		}
		

	}

}