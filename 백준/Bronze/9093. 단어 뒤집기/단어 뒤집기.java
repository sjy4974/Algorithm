import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		for(int i =0; i<T; i++) {			
			String[] str = br.readLine().split(" ");
			for(int j = 0; j<str.length; j++) {
				sb = new StringBuilder();
				sb.append(str[j]);
				System.out.print(sb.reverse().toString()+" ");
			}
			if(i != T-1) {				
				System.out.println();
			}
		}	
	}

}