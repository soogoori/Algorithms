package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// binary search 이용
public class BaekJoon_2805 {

    static int N, arr[];
    static long M;

    static int bs(int l, int r){
        int mid =0;
        int ans = 0;

        while(l<=r){
            mid = (l+r)/2;
            int sum=0;
            for(int i=0; i<N; i++){
                if(arr[i]>mid){
                    sum+=arr[i]-mid;
                }
            }
            if(sum<M){
                r=mid-1;
            }else{
                ans = mid;
                l = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bs(0, 1000000));
    }
}
