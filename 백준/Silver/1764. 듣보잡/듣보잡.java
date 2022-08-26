import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		List<String> list = new ArrayList<String>();
		for(int i =0; i <N; i++) {
			map.put(br.readLine(), i);
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<M; i++) {
			String input = br.readLine();
			if(map.containsKey(input)) {
				list.add(input);
				cnt++;
			}
		}
		Collections.sort(list);
		for(String str : list) {
			sb.append(str+"\n");
		}
		System.out.print(cnt+"\n"+sb.toString());
		
	}

}