package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17427_약수의합2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long sum=0;

        for(int i=1; i<=N; i++){
            sum+=i*(N/i);
        }
        System.out.println(sum);
    }
}
