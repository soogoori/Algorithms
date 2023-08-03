package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 슬라이딩 윈도우
 */
public class BOJ_1522_문자열교환 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ab = br.readLine();

        System.out.println("ab = " + ab);

        int cntA=0;
        for (int i = 0; i < ab.length(); i++) {
            if (ab.charAt(i) == 'a') {
                cntA++;
            }
        }

        int min=Integer.MAX_VALUE;
        for (int i = 0; i < ab.length(); i++) {
            int cntB=0;
            for (int j = i; j < i + cntA; j++) {
                if (ab.charAt(j%ab.length()) == 'b') {
                    cntB++;
                }
            }
            min = Math.min(min, cntB);
        }

        System.out.println("min = " + min);
    }
}
