package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 가중치를 두고 생각하기
 */
public class BOJ_1339_단어수학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] alpha = new Integer[26];

        Arrays.fill(alpha, 0);

        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();

            for (int j = str.length-1; j >= 0; j--) {
                alpha[str[j]-'A'] += (int)Math.pow(10, str.length-j-1);
            }
        }

        Arrays.sort(alpha, Collections.reverseOrder());

        for (Integer integer : alpha) {
            System.out.println("integer = " + integer);
        }

        int value = 9, answer = 0;

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] == 0) {
                break;
            }
            answer+=alpha[i]*value--;
        }
        System.out.println(answer);
    }
}
