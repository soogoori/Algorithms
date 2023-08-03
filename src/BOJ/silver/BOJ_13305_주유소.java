package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_주유소 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] length = new long[N];
        long[] price = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N-1; i++){
            length[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            price[i] = Long.parseLong(st.nextToken());
        }

        //int idx = 1;

        long min = 0;
        long minPrice=price[1];

        for(int i=1; i<N; i++){
            if(price[i]<minPrice){
                minPrice = price[i];
            }
            min+=minPrice * length[i];
        }

        /*while(idx!=N-1){
            if(price[idx]>price[idx+1]){
                min += (long)price[idx] * length[idx];
                idx++;
            }else{
                minPrice = price[idx];
                while(minPrice<=price[idx]){
                    min+=(long)minPrice * length[idx];
                    if(idx==N-1)  break;
                    else    idx++;
                }
            }
        }*/

        System.out.println(min);
    }
}
