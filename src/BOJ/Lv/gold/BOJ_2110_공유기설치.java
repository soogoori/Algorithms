package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이분탐색 어렵군.
 */
public class BOJ_2110_공유기설치 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기 개수
        int[] house = new int[N+1];

        for (int i = 1; i <= N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 1;
        int right = house[N] - house[1];
        int dist=0;
        int ans=0;

        while (left <= right) {
            int mid = (left+right)/2;
            int start = house[1];
            int count=1;

            for (int i = 1; i <= N; i++) {
                dist = house[i]-start;

                if (dist >= mid) {
                    count++;
                    start = house[i];
                }
            }

            if (count >= C) {
                ans=mid;
                left = mid + 1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(ans);
    }

}
