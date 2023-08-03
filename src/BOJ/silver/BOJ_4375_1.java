package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_4375_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while((input=br.readLine())!=null){
            int n = Integer.parseInt(input);
            int remain = 0;
            for (int i = 1; ; i++) {
                remain = (remain*10+1)%n;
                if (remain == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
