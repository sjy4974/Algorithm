import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,k;
	static int [] visited;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		visited = new int[100001];
		
		if ( n == k){
            System.out.println(0);
        } else {
            bfs(n);
        }


	}
	
	static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(n);
		visited[n] = 1;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			for(int i =0; i< 3; i++) {
				int next;
				if(i==0) {
					next = x + 1;
				} else if (i == 1) {
					next = x -1;
				}else {
					next = x * 2;
				}
				
				if(next == k) {
					System.out.println(visited[x]);
					return;
				}
				
				if ( next >= 0 && next < visited.length && visited[next] == 0) {
					queue.add(next);
					visited[next] = visited[x] + 1;
				}
			}
		}
		
	}

	
	
}

