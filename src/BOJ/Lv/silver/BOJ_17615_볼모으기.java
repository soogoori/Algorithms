package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 그리디 알고리즘
 */
public class BOJ_17615_볼모으기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int red=0;
        int blue=0;
        int answer=Integer.MAX_VALUE;

        String color = br.readLine();

        for (int i = 0; i < N; i++) {
            if (color.charAt(i) == 'R') {
                red++;
            } else {
                blue++;
            }
        }

        int cnt=0;
        for (int i = 0; i < N; i++) {
            if (color.charAt(i) == 'R') {
                cnt++;
            }else
                break;
        }
        answer = Math.min(answer, red - cnt);

        cnt=0;
        for (int i = N - 1; i >= 0; i--) {
            if (color.charAt(i) == 'R') {
                cnt++;
            }else
                break;
        }
        answer = Math.min(answer, red - cnt);

        cnt=0;
        for (int i = 0; i < N; i++) {
            if (color.charAt(i) == 'B') {
                cnt++;
            }else
                break;
        }
        answer = Math.min(answer, blue - cnt);

        cnt=0;
        for (int i = N - 1; i >= 0; i--) {
            if (color.charAt(i) == 'B') {
                cnt++;
            }else
                break;
        }
        answer = Math.min(answer, blue - cnt);

        System.out.println(answer);
    }
}
