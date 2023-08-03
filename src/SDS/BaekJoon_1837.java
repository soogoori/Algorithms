package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1837 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String P = st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        int r=Integer.MAX_VALUE;

        boolean isPrime[] = new boolean[100001];

        for(int i=2; i<=K; i++){
            if(!isPrime[i]){
                for(int j= i*2; j<K; j+=i){
                    isPrime[j]=true;
                }
            }
        }

        for(int i=2; i<K; i++) {
            if (!isPrime[i]) {
                int n = 0;
                for (int j = 0; j < P.length(); j++) {
                    n+=10;
                    n+=P.charAt(j)-'0';
                    if(n>=i){
                        n%=i;
                    }
                }
                if (n == 0) {
                    System.out.println("BAD " + i);
                    return;
                }
            }
        }
        System.out.println("GOOD");
    }
}
