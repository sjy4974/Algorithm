import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int V;
	static int E;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		map = new int[V + 1][V + 1];
		visited = new boolean[V+1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		bfs(1);

	}
	static void bfs(int num) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int cnt = 0;
		visited[num] = true;
		deque.addLast(num);
		
		while(!deque.isEmpty()) {
			int v = deque.pollFirst();
			
			for(int i =0; i<map.length; i++) {
				if(map[v][i] == 1 && !visited[i]) {
					deque.addLast(i);
					visited[i] = true;
					cnt ++;
				}
			}
		}
		System.out.println(cnt);
	}

}