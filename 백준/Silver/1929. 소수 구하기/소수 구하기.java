import java.util.Scanner;

public class Main {

	static boolean prime[] = new boolean[1000001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		prime[0] = true;
		prime[1] = true;
		
		for (int i = 1; i * i <= N; i++) {
	
			if (!prime[i]) {
				for (int j = i * i; j <= N; j += i)
					prime[j] = true;
			}
		}

		for (int i = M; i <= N; i++) {
			if (!prime[i])
				System.out.println(i);
		}
	}

}