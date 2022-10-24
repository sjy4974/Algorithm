import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<String> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i =0; i <N; i++) {
			String[] str = br.readLine().split(" ");
			if(str.length == 2) {
				deque.addLast(str[1]);
			} else {
				if(str[0].equals("pop")) {
					if(deque.isEmpty()) {
						sb.append(-1+"\n");
					} else {
						sb.append(deque.pollFirst()+"\n");
					}
				} else if(str[0].equals("size")) {
					sb.append(deque.size()+"\n");
				} else if(str[0].equals("empty")) {
					if(deque.isEmpty()) {
						sb.append(1+"\n");
					} else {
						sb.append(0+"\n");
					}
				} else if(str[0].equals("front")) {
					if(deque.isEmpty()) {
						sb.append(-1+"\n");
					} else {
						sb.append(deque.peekFirst()+"\n");
					}
				} else if (str[0].equals("back")) {
					if(deque.isEmpty()) {
						sb.append(-1+"\n");
					} else {
						sb.append(deque.peekLast()+"\n");
					}
				}
			}
		}
		System.out.println(sb.toString());
		
	}

}
