package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *  백트래킹
 */
public class BOJ_2661_좋은수열 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        backTracking("");
    }

    public static void backTracking(String s) {
        if (s.length() == N) {
            System.out.println(s);
            System.exit(0);
        } else {
            for (int i = 1; i <= 3; i++) {
                if (check(s + i)) {
                    backTracking(s + i);
                }
            }
        }
    }

    public static boolean check(String str) {
        int length = str.length()/2;

        for (int i = 1; i <= length; i++) {
            if (str.substring(str.length() - i).equals(str.substring(str.length() - 2 * i, str.length() - i))) {
                return false;
            }
        }
        return true;
    }
}
