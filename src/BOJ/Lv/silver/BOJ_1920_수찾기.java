package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

    static int N,M;
    static int[] num, match;

    static int bSearch(int i){

        int s = 0;
        int l = N-1;
        int mid;

        while (s <= l) {
            mid = (s+l)/2;
            if (num[mid] < match[i]) {
                s = mid+1;
            }else if(num[mid] > match[i]){
                l = mid-1;
            }else   return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        M = Integer.parseInt(br.readLine());
        match = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            match[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            System.out.println(bSearch(i));
        }
    }
}
