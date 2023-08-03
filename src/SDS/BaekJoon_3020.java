package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 누적합 -1, 1
public class BaekJoon_3020 {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int data[] = new int[N+1];
        int idx[] = new int[H + 1];
        int sum[] = new int[H + 1];
        for(int i=1; i<=N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        for(int i=1; i<=N; i++){
            if((i%2==1) && data[i]<H){
                idx[i]++;
                idx[data[i]+1] = -1;
            }else{
                idx[data[i]]++;
            }
        }

        for(int i=1; i<=H; i++){
            for(int j = 1; j<=i; j++){
                sum[i] = idx[j];
            }
        }


        int min = sum[1];
        int cnt = 1;
        for(int i =2; i<sum.length; i++){
            if(sum[i]<min){
                min = sum[i];
                cnt=1;
            }else if(sum[i] == min){
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
}
