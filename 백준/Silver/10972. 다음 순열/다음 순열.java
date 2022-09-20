import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int A,B,C;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		if (nextPerm()) {
			int temp = arr[B];
			arr[B] = arr[C];
			arr[C] = temp;
			if ((arr.length - 1) - B > 1) {
				int left = B + 1;
				int right = arr.length - 1;
				while (left < right) {
					int tmp = arr[left];
					arr[left] = arr[right];
					arr[right] = tmp;
					left++;
					right--;
				}
			}
			for(int num : arr) {
				System.out.print(num+" ");
			}
		} else {
			System.out.println(-1);
		}
		
	}
	
	public static boolean nextPerm() {

		for (int i = arr.length - 1; i >= 0; i--) {
			if (i > 0 && arr[i] > arr[i - 1]) {
				A = i;
				B = i - 1;
				for (int j = arr.length - 1; j >= A; j--) {
					if (arr[j] > arr[B]) {
						C = j;
						return true;
					}
				}
			}
		}
		return false;
	}

}