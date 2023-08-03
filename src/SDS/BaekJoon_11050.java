package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_11050 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int a=1;
        int b=1;
        for(int i=N; i>=N-K+1; i--){
            a*=i;
        }
        for(int i=K; i>=1; i--){
            b*=i;
        }
        System.out.println(a/b);
    }
}
