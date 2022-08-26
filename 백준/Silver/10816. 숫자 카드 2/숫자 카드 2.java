import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i =0; i < N; i++) {
			int num = sc.nextInt();
			if(!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num)+1);
			}
		}
		
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < M; i++) {
			int num = sc.nextInt();
			if(!map.containsKey(num)) {
				sb.append(0+" ");
			} else {
				sb.append(map.get(num)+" ");
			}
		}
		
		System.out.println(sb.toString());
		
	}

}