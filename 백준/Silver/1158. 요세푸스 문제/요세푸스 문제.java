import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		for (int i=0;i<N;i++) {
			list.add(i+1);
		}
		
		String res = "<";
        while(!list.isEmpty()) {
            for (int i = 0; i < K; i++) {
                if (i == K - 1) {
                    int temp = list.remove();
                    if (list.size() == 0) {
                        res += temp;
                    } else {
                        res += temp + ", ";
                    }
                } else {
                    list.add(list.remove());
                }
            }
        }
        
        System.out.println(res+">");
	}
	
	
}