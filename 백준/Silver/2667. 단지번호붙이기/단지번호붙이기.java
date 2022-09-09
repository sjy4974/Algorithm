import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> aparts = new ArrayList<Integer>();
	static int apartNum;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i =0; i<n; i++) {
			String str = br.readLine();
			for(int j =0; j<n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i =0; i<n; i++) {
			for( int j=0; j<n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					apartNum++;
					bfs(i,j);
				}
			}
		}
		
		System.out.println(apartNum);
		
		Collections.sort(aparts);
		for(int i : aparts) {
			System.out.println(i);
		}

	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		
		visited[x][y] = true;
		int count = 1;
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			
			for(int i =0; i<4; i++ ) {
				int nextX = xy[0] + dx[i];
				int nextY = xy[1] + dy[i];
				
				if(nextX >=0 && nextX <n && nextY >=0 && nextY <n) {
					if(map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
						queue.add(new int[] {nextX,nextY});
						visited[nextX][nextY] = true;
						count++;
					}
				}
			}
			
		}
		aparts.add(count);
		
		
		
	}
}