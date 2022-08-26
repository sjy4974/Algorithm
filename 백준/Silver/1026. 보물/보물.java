import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++) {
			list1.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++) {
			list2.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list1);
		Collections.sort(list2,Collections.reverseOrder());;
		int ans = 0;
		for(int i =0; i< N; i++) {
			ans += list1.get(i) * list2.get(i);
		}
		
		System.out.println(ans);
	}

}