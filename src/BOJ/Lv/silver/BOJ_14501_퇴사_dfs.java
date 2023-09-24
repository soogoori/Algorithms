package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 이익 구하기_dfs
 */
public class BOJ_14501_퇴사_dfs {

    static int N, answer;
    static int[] T, P;

    static void dfs(int day, int price) {
        if (day >= N) {
            answer = Math.max(answer, price);
            return;
        }

        if (day + T[day] <= N) {
            dfs(day + T[day], P[day] + price);
        } else {
            dfs(day + T[day], price);
        }
        dfs(day + 1, price);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(answer);
    }
}
