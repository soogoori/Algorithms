package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1911_흙길보수하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] puddle = new int[N][2];

        int max=0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            puddle[i][0] = Integer.parseInt(st.nextToken());
            puddle[i][1] = Integer.parseInt(st.nextToken());
            max = Math.max(max, puddle[i][1]);
        }

        int cnt=0;
        int range=0;

        Arrays.sort(puddle, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0]; // 첫번째 기준 오름차순
            }
        });

        for (int i = 0; i <N; i++) {
            int start = puddle[i][0];
            int end = puddle[i][1];

            if (start > range) {
                range = start;
            }
            if (end >= range) {
                while (end>range) {
                    range+=L;
                    cnt++;
                }
            }
        }
        System.out.println("cnt = " + cnt);
    }
}
