package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배낭문제 기초
 * dp 이용해서 풀어야 함.
 */
public class BOJ_12865_평범한배낭 {

    static int N, K;
    static int[][] wv;
    static int maxVal = Integer.MIN_VALUE;

    static void dfs(int depth, int weight, int val) {
        if (depth == N) {
            maxVal = Math.max(maxVal, val);
            return;
        }

        if (weight + wv[depth][0] <= K) {
            dfs(depth + 1, weight + wv[depth][0], val + wv[depth][1]);
        }

        if (weight <= K) {
            dfs(depth + 1, weight, val);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        wv = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wv[i][0] = Integer.parseInt(st.nextToken());
            wv[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        System.out.println(maxVal);
    }
}
