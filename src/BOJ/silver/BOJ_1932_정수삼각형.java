package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        ArrayList<Integer>[] arrayLists = new ArrayList[n];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arrayLists[i].add(Integer.parseInt(st.nextToken()));
        }

        dp[0]=0;
        dp[1] = arrayLists[1].get(0);

        if (n == 1) {
            System.out.println(dp[1]);
            return;
        }


    }
}
