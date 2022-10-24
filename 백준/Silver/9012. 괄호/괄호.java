import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<String>();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			boolean check = true;
			for(int i =0; i <str.length(); i++) {
				if(str.charAt(i) == '(') {
					stack.add(str.charAt(i)+"");
				} else {
					if(!stack.isEmpty()){
						stack.pop();
					} else {
						check = false;
						break;
					}
				}
			}
			if(check && stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			stack.clear();
			
		}
	}

}
