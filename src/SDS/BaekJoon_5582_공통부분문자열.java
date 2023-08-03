package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_5582_공통부분문자열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int lengthA = A.length();
        int lengthB = B.length();
        int dp[][] = new int[lengthB+1][lengthA+1];

        int max = 0;

        for(int i=1; i<=lengthB; i++){
            for(int j=1; j<=lengthA; j++){
                if (A.charAt(j - 1) == B.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] +1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}
