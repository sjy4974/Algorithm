import java.util.Scanner;

public class Main {
	static int N;
	static String a="";
	static String f = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		re(0,"");
	}
	
	
	public static void re(int idx, String s) {

		
		if(idx == N) {
			System.out.println(a+"____\"재귀함수가 뭔가요?\"");
			System.out.println(a+"____"+f);
			System.out.println(a+"____라고 답변하였지.");
			return;
		}
		
		String s1 = "\"재귀함수가 뭔가요?\"";
		String s2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		String s3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		String s4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		
		String s5 = "라고 답변하였지.";
		
		if( idx > 0) {
			a += "____";
			s1 = a+s1;
			s2 = a+s2;
			s3 = a+s3;
			s4 = a+s4;
			s5 = a+s5;
		}
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		re(idx+1,a);
		System.out.println(s5);
		
	}

}