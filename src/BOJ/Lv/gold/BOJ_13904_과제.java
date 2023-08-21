package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 그리디 알고리즘
 */
public class BOJ_13904_과제 {
    static int N;

    static class Info{
        int d, w;

        public Info(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Info> list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        int maxDay = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Info(d, w));
            maxDay = Math.max(maxDay, d);
        }

        // N일째부터 1일째까지 거꾸로 돌면서 n일차 과제 중 최대 점수 선택
        int sum=0;
        for (int i = maxDay; i >= 1; i--) {
            Info inf = new Info(0, 0);

            for (Info info : list) {
                if (info.d >= i) {
                    if (info.w > inf.w) {
                        inf = info;
                    }
                }
            }

            sum+=inf.w;
            list.remove(inf);
        }

        System.out.println(sum);
    }

}
