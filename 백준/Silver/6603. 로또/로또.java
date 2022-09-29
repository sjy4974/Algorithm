import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int K;
	
	static int[] temp = new int[6];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K == 0) break;
			arr = new int[K];
			for(int i =0; i <K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			comb(0,0);
			System.out.println();
			
		}
	}
	
	static void comb(int idx, int sidx) {
		if(sidx == 6) {
			for(int num : temp) {
				System.out.print(num+" ");
			}
			System.out.println();
			return;
		}
		for(int i = idx; i<=K-6+sidx; i++) {
			temp[sidx] = arr[i];
			comb(i+1,sidx+1);
		}
	}

}