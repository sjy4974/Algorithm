import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        System.out.println(han(num));
        
    }
    
    public static int han(int number){
        
        int cnt = 0;
        
        if (number < 100){
            return number;
        }else{
            cnt = 99;
            if(number == 1000){
                number --;
            }
            for(int i = 100; i <= number; i++){
                int hun = i / 100;
                int ten = (i/10) %10;
                int one = i%10;
                
                if(hun - ten == ten - one){
                    cnt ++;
                }
                
            }
        }
        return cnt;
    }
}