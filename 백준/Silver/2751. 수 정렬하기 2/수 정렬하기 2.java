import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i = 0; i < N; i++) {
			queue.add(Integer.parseInt(br.readLine()));
		}
		
		while(!queue.isEmpty()) {
			bw.write(String.valueOf(queue.poll()));
			bw.write("\n");
			
		}
		bw.flush();
		
	}

}