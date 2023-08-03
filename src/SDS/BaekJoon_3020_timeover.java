package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 누적합
public class BaekJoon_3020_timeover {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int data[] = new int[N+1];
        int idx[] = new int[H + 1];
        for(int i=1; i<=N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        for(int i=1; i<=N; i++){
            if(i%2==1){
                for(int j=1; j<=data[i]; j++)
                    ++idx[j];
            }else{
                for(int j=H; j>=H-data[i]+1; j--)
                    ++idx[j];
            }
        }

        int min = idx[1];
        int cnt = 1;
        for(int i =2; i<idx.length; i++){
            if(idx[i]<min){
                min = idx[i];
                cnt=1;
            }else if(idx[i] == min){
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
}
