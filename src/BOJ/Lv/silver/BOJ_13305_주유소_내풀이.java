package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알고보면 쉬운 문제인데.... 어렵게 접근함.. 그래도 맞았다...
 */
public class BOJ_13305_주유소_내풀이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] distance = new long[N - 1];
        long[] price = new long[N];
        int r=0, l=1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long minPrice=0;

        while (l < N-1) {
            if (price[r] > price[l]) {
                minPrice += price[r] * distance[l - 1];
                r=l;
                l++;
            } else {
                minPrice += price[r] * distance[l - 1];
                l++;
            }
        }
        minPrice += price[r] * distance[l - 1];

        System.out.println(minPrice);
    }
}
