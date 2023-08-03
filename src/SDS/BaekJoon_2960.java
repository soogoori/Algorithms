package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2960 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        boolean check[] = new boolean[1001];

        for(int i=2; i<=N; i++){
            if(!check[i]){
                check[i] = true;
                cnt++;
            }
            if(cnt==K){
                System.out.println(i);
                return;
            }
            for(int j=i*i; j<=N; j+=i){
                if(check[j] ==false){
                    cnt++;
                    check[j] = true;
                }
                if(cnt==K){
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
