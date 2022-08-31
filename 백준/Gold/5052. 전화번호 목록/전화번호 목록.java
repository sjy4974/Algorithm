import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Trie{
	boolean isLast;
	private Map<Character,Trie> cn = new HashMap<>();
	
	public Trie() {
		isLast = false;
	}
	
	public Map<Character, Trie> getChildNodes(){
		return this.cn;
	}
	public boolean isLastNode() {
		return isLast;
	}
	
	public void setLastNode(boolean isLastChar) {
		isLast = isLastChar;
	}
	
	public void insert(String num) {
		Trie trie = this;
		for( int i =0; i < num.length(); i++) {
			if(trie.getChildNodes().get(num.charAt(i)) == null) {
				trie.getChildNodes().put(num.charAt(i), new Trie());
			}
			trie = trie.getChildNodes().get(num.charAt(i));
		}
		//num의 마지막 문자까지 왔다면 마지막문자에 isLast를 true로 바꿈
		trie.setLastNode(true);
	}
	
	public boolean contain(String num) {
		Trie thisNode = this;
		
		for ( int i = 0; i < num.length(); i++) {
			thisNode = thisNode.getChildNodes().get(num.charAt(i));
			
		}
		
		if(thisNode.getChildNodes().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
}

public class Main {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Trie trie = new Trie();
			String[] str = new String[N];
			
			for(int i =0; i < N; i++) {
				String num = br.readLine();
				str[i] = num;
				trie.insert(num);
			}
			boolean check = true;
			
			for(int i = 0; i < N; i++) {
				check = trie.contain(str[i]);
				if(!check) break;
			}
			
			if(check) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
			
		}
	}

}