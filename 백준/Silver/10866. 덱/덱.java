import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<String> deque = new ArrayDeque<>();
		
		for(int i =0; i <N; i++) {
			String[] str = br.readLine().split(" ");
			
			if(str.length == 2) {
				if(str[0].equals("push_front")) {
					deque.addFirst(str[1]);
				} else if(str[0].equals("push_back")) {
					deque.addLast(str[1]);
				}
			} else {
				switch(str[0]) {
				case "pop_front":
					if(!deque.isEmpty()) {
						sb.append(deque.pollFirst());
					} else {
						sb.append("-1");
					}
					break;
				case "pop_back":
					if(!deque.isEmpty()) {
						sb.append(deque.pollLast());
					} else {
						sb.append("-1");
					}
					break;
				case "size":
					sb.append(deque.size());
					break;
				case "empty":
					if(!deque.isEmpty()) {
						sb.append("0");
					} else {
						sb.append("1");
					}
					break;
				case "front":
					if(!deque.isEmpty()) {
						sb.append(deque.peekFirst());
					} else {
						sb.append("-1");
					}
					break;
				case "back":
					if(!deque.isEmpty()) {
						sb.append(deque.peekLast());
					} else {
						sb.append("-1");
					}
					break;
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
