import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i =0; i<N; i++) {
			String str[] = br.readLine().split(" ");
			switch(str[0]) {
			case "push":
				stack.push(str[1]);
				break;
			case "pop":
				if(stack.isEmpty()) {
					sb.append(-1+"\n");
				} else {
					sb.append(stack.pop()+"\n");
				}
				break;
			case "size":
				sb.append(stack.size()+"\n");
				break;
			case "empty":
				if(stack.isEmpty()) {
					sb.append(1+"\n");
				} else {
					sb.append(0+"\n");
				}
				break;
			case "top":
				if(stack.isEmpty()) {
					sb.append(-1+"\n");
				} else {
					sb.append(stack.peek()+"\n");
				}
				break;
			}
			
		}
		System.out.print(sb.toString());
	}

}