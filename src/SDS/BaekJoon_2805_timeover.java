package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_2805_timeover {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int height = 0;

        int i=0;
        int j=0;

        st = new StringTokenizer(br.readLine());

        for(i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int h = max-(int)M;
        System.out.println("h = " + h);

        for(i=h; i<=max; i++){
            int cut = 0;
            for(j=0; j<arr.length; j++){
                if(arr[j]-i>0){
                    cut+=arr[j]-i;
                }
                if(cut>M){
                    break;
                }
            }
            if(cut == M){
                height = i;
            }
        }
        System.out.println(height);
    }
}
