import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static String[] arr;
	static String[] res;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<String>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new String[C];
		res = new String[L];
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<C; i++) {
			arr[i] = st.nextToken();
		}
		set.add("a");
		set.add("e");
		set.add("i");
		set.add("o");
		set.add("u");
		Arrays.sort(arr);
		comb(0,0);
		System.out.println(sb.toString());
	
	}
	public static void comb(int idx, int dept) {
		if(dept == L) {
			int cnt = 0;
			
			for(int i =0; i<L; i++) {
				if(set.contains(res[i])) {
					cnt++;
				}
			}
			
			if(cnt == 0 || L-cnt < 2) {
				return;
			}
			
			
			for(int i=0; i<L;i++) {
				sb.append(res[i]);
			}
			sb.append("\n");
			return;
		}
		
		for(int i =idx; i <C; i++) {
			if(!visited[i]) {
				visited[i] = true;
				res[dept] = arr[i];
				comb(i+1, dept+1);
				visited[i] = false;
			}
		}
	}
}
