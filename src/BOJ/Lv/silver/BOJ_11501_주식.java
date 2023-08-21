package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그리디 알고리즘 → 생각의 전환
 */
public class BOJ_11501_주식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] stock = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }

            int max=0;
            int sum = 0;

            for (int k = N - 1; k >= 0; k--) {
                if (max < stock[k]) {
                    max = stock[k];
                } else {
                    sum += max - stock[k];
                }
            }
            System.out.println("sum = " + sum);
        }
    }
}
