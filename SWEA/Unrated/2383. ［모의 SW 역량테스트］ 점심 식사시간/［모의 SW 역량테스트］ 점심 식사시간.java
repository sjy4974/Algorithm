import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class Person{
		int r, c;
		int stair;
		int arriveTime;
		int startedTime;
		
		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		private void calArriveTime() {
			this.arriveTime = Math.abs(r - stairs[stair].r) + Math.abs(c - stairs[stair].c);
		}
	}
	
	static class Stair{
		int r, c;
		int k;
		
		public Stair(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}
	
	static Stair[] stairs;
	static Queue<Person>[] qs;
	static ArrayList<Person> persons;
	static boolean[] started;
	static int min;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			persons = new ArrayList<>();
			qs = new LinkedList[2];
			qs[0] = new LinkedList<>();
			qs[1] = new LinkedList<>();
			stairs = new Stair[2];
			
			min = Integer.MAX_VALUE;
			
			int stairIdx = 0;
			for(int r= 1; r<=N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c =1; c<=N; c++) {
					int num = Integer.parseInt(st.nextToken());
					
					if(num == 0) continue;
					else if(num == 1) {
						persons.add(new Person(r,c));
					} else {
						stairs[stairIdx++] = new Stair(r,c,num);
					}
				}
			}
			go(0);
			System.out.println("#"+tc+" "+min);
		}
	}
	
	
	
	private static void go(int idx) {
		
		if(idx == persons.size()) {
			
			started = new boolean[persons.size()];
			
			int time = simulation();
			if(time < min) {
				min = time;
			}
			return;
		}
		
		persons.get(idx).stair = 0;
		persons.get(idx).calArriveTime();
		go(idx+1);
		
		persons.get(idx).stair = 1;
		persons.get(idx).calArriveTime();
		go(idx+1);
	}



	private static int simulation() {
		int cnt = 0;
		int time = 1;
		
		while(true) {
			
			for(Queue<Person> q: qs) {
				int size = q.size();
				for(int i =0; i<size; i++) {
					Person p = q.poll();
					Stair s = stairs[p.stair];
					
					if(time >= p.startedTime + s.k) {
						continue;
					}
					q.offer(p);
				}
			}
			
			
			if(cnt == persons.size() && qs[0].isEmpty() && qs[1].isEmpty()) {
				return time;
			}
			
			for(int i =0; i< persons.size(); i++) {
				if(started[i]) {
					continue;
				}
				Person p = persons.get(i);
				Queue<Person> q= qs[p.stair];
				
				if(q.size() < 3 && p.arriveTime + 1 <= time) {
					p.startedTime = time;
					started[i] = true;
					q.offer(p);
					cnt++;
				}
			}
			
			time++;
		}
	}

}