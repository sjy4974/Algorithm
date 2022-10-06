import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] rs = new String[2];
		rs[0] = "SK";
		rs[1] = "CY";
		System.out.println(rs[N%2]);
	}

}