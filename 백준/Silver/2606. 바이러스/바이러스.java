import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int vertices;
	static int edges;
	static boolean[] visited;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		vertices = Integer.parseInt(br.readLine());
		edges = Integer.parseInt(br.readLine());
		
		graph = new int[vertices+1][vertices+1];
		visited = new boolean[vertices+1];
		for (int i=0; i< edges; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			graph[a][b] = 1;
			graph[b][a] = 1;
			
		}
		bfs(1);
		
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		visited[start] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for(int i=1; i < graph.length ; i++) {
				if(graph[node][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					count ++;
				}
			}
		}
		System.out.println(count);
		
	}
}