import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static boolean[] check;
	static int[] arr;
	static Set<Integer> set;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		check = new boolean[N];
		int sum = 0;
		for(int i =0; i< N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
			sum += temp;
		}
		
		set = new HashSet<Integer>();
		
		powerSet(0);
		
		System.out.println(sum-set.size()+1);
	}
	
	static void powerSet(int idx) {
		if (idx == N) {
			int sum =0;
			for(int i =0; i < N; i++) {
				if(check[i]) {
					sum += arr[i];
				}
			}
			set.add(sum);
			return;
		}
		check[idx] = true;
		powerSet(idx+1);
		check[idx] = false;
		powerSet(idx+1);
	}

}