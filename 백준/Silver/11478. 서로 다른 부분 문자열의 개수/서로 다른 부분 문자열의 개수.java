import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ca = br.readLine().toCharArray();
		Set<String> set = new HashSet<>();
		for(int i =0; i <ca.length; i++) {
			String temp = ca[i]+"";
			set.add(temp);
			for(int j = i+1; j < ca.length; j++) {
				temp += ca[j];
				set.add(temp);
			}
		}
		System.out.println(set.size());
		
		
	}

}