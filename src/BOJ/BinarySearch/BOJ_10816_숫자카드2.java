package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {

    static int N,M;
    static int[] card;
    static int[] cnt;

    static int lowerBound(int n){

        int s = 0;
        int e = N;

        while (s < e) {
            int mid = (s+e)/2;

            if (card[mid] >= cnt[n]) {
                e = mid;
            }else{
                s = mid+1;
            }
        }
        return s;
    }

    static int upperBound(int n){
        int s = 0;
        int e = N;

        while (s < e) {
            int mid = (s+e)/2;

            if (card[mid] <= cnt[n]) {
                s = mid+1;
            }else{
                e = mid;
            }
        }
        return s;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        card = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        M = Integer.parseInt(br.readLine());
        cnt = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            System.out.print(upperBound(i)-lowerBound(i)+ " ");
        }
    }
}
