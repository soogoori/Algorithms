package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최장 연속 부분 수열의 길이
 */
public class BOJ_20922_겹치는건싫어 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ls = new int[N];
        int[] check = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls[i] = Integer.parseInt(st.nextToken());
        }

        int r=0, l=0;
        int len=0;
        int max = Integer.MIN_VALUE;

        while (l < N) {
            while (l<N && check[ls[l]]<K) {
                check[ls[l]]++;
                l++;
            }
            len = l-r;
            max = Math.max(len, max);
            check[ls[r]]--;
            r++;
        }
        System.out.println(max);
    }
}
