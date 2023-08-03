package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_9252_LCS2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int lengthA = A.length();
        int lengthB = B.length();
        int dp[][] = new int[lengthA + 1][lengthB + 1];

        int max = 0;

        for (int i = 1; i <= lengthA; i++) {
            for (int j = 1; j <= lengthB; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        String answer = "";

        int i = dp.length-1, j = dp[0].length-1;
        while (i != 0 && j != 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                answer += A.charAt(i - 1);
                i--;
                j--;
            }
        }

        System.out.println(dp[lengthA][lengthB]);
        System.out.print(new StringBuilder(answer).reverse());
    }
}
