package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이진탐색 -> upperBound & lowerBound
 */
public class BOJ_10816_숫자카드2 {

    static int N,M;
    static int[] card;
    static int[] match;

    static int upperBound(int n){

        int s=0;
        int l = N;
        int mid;

        while (s < l) {
            mid = (s+l)/2;
            if (card[mid] <= match[n]) {
                s = mid +1;
            } else {
                l = mid;
            }
        }
        return s;
    }

    static int lowerBound(int n){

        int s=0;
        int l = N;
        int mid;

        while (s < l) {
            mid = (s+l)/2;
            if (card[mid] < match[n]) {
                s = mid +1;
            } else {
                l = mid;
            }
        }
        return s;
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

        for (int i = 0; i < M; i++){
            System.out.print(upperBound(i) - lowerBound(i) + " ");
        }
    }
}
