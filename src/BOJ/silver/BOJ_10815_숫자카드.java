package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Binary Search - 이분탐색
 */
public class BOJ_10815_숫자카드 {

    static int N,M;
    static int[] card;
    static int[] match;

    static int BSearch(int n){

        int s = 0;
        int l = N-1;
        int mid;

        while (s <= l) {
            mid = (s+l)/2;
            if (card[mid] < match[n]) {
                s = mid+1;
            } else if (card[mid] > match[n]) {
                l = mid-1;
            }else   return 1;
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
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
        match = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            match[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            System.out.print(BSearch(i) + " ");
        }
    }
}
