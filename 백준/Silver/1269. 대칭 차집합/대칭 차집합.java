import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arrA;
	static int[] arrB;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		Map<Integer,Integer> mapA = new HashMap<Integer,Integer>();		
		Map<Integer,Integer> mapB = new HashMap<Integer,Integer>();
		arrA = new int[A];
		arrB = new int[B];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < A; i++) {
			int num = Integer.parseInt(st.nextToken());
			arrA[i] = num;
			mapA.put(num, 0);
		}
		
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		int cnt = 0;
		for(int i = 0; i < B; i++) {
			int num = Integer.parseInt(st.nextToken());
			arrB[i] = num;
			mapB.put(num, 0);
			
			if(!mapA.containsKey(num)){
				ans++;
			} else {
				cnt++;
			}
		}
		
		ans += mapA.size() - cnt;
		System.out.println(ans);
		
		
	}

}