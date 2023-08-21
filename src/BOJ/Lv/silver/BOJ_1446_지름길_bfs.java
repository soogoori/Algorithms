package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다익스트라, bfs → 이해안감...
 */
public class BOJ_1446_지름길_bfs {

    static int N, D;
    static Info[] info;
    static int[] dp;
    static int result;

    static class Info implements Comparable<Info> {
        int s, e, d;

        public Info(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Info o) {
            return this.s - o.s;
        }
    }

    static void dijkstra() {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, 0, 0));
        dp[0] = 0;

        while (!pq.isEmpty()) {
            Info now = pq.poll();
            int destination = now.d;

            for (Info inf : info) {
                if (inf.s >= destination) {
                    if(inf.d > D)   continue;
                    int tmp = inf.s - destination;

                    if (dp[inf.d] > dp[destination] + inf.d + tmp) {
                        dp[inf.d] = dp[destination] + inf.d + tmp;
                        pq.add(new Info(destination, inf.d, dp[inf.d]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        info = new Info[N];
        dp = new int[D+1];

        Arrays.fill(dp, 10001);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (end > D || end - start < dist)  continue;
            info[i] = new Info(start, end, dist);
        }

        dijkstra();
        System.out.println(dp[D]);
    }
}
