import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
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
		String[] arr = new String[N+1];
		for(int i = 1; i <= N; i++) {
			String input = br.readLine();
			map.put(input,i);
			arr[i] = input;
		}
		StringBuilder sb = new StringBuilder();
		for(int i =1; i <= M; i++) {
			String input = br.readLine();
			if(Character.isDigit(input.charAt(0))) {
				sb.append(arr[Integer.parseInt(input)]+"\n");
			} else {
				sb.append(map.get(input)+"\n");
			}
		}
		
		System.out.print(sb.toString());
		
	}

}