import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for(int tc = 1; tc <=T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			Deque<int[]> deque = new ArrayDeque<int[]>();
			st = new StringTokenizer(br.readLine());
			Integer[] arr = new Integer[N];
			for(int i =0; i<N; i++) {
				int value = Integer.parseInt(st.nextToken());
				deque.addLast(new int[]{i,value});
				arr[i] = value;
			}
			
			Arrays.sort(arr,Collections.reverseOrder());
			int[] temp;
			int cnt = 0;
			int idx = 0;
			while(idx<N) {
				temp = deque.pollFirst();
				if(arr[idx] == temp[1]) {
					if(temp[0] == target) {
						cnt++;
						break;
					} else {
						idx++;
						cnt++;
					}
				} else {
					deque.addLast(temp);
				}
			}
			System.out.println(cnt);
		}
	}

}