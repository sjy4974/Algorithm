import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for(int i =0; i < K; i++) {
			int num = sc.nextInt();
			
			if(num == 0) {
				deque.pollLast();
			} else {
				deque.offer(num);
			}
		}
		int ans = 0;
		while(!deque.isEmpty()) {
			ans+=deque.pollLast();
		}
		System.out.println(ans);
		
		
	}

}