import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] memo;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		memo = new int[n+1];
		
		for(int i = 1; i <=n; i++) {
			if(i == 1) {
				memo[1] = 1;
			} else if(i == 2) {
				memo[2] = 2;
			} else if(i == 3) {
				memo[3] = 3;
			} else {
				memo[i] = (memo[i-1]+memo[i-2])%10007;
			}
		}
		System.out.println(memo[n]);
		
	}

}