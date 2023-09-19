package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 우선순위 큐
 * 그리디 알고리즘
 */
public class BOJ_1826_연료채우기 {

    static int N, L, P;
    static PriorityQueue<Info> gasStation;

    static class Info implements Comparable<Info>{
        int dist, amount;

        public Info(int dist, int amount) {
            this.dist = dist;
            this.amount = amount;
        }
        @Override
        public int compareTo(Info o) {
            return this.dist-o.dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        gasStation = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gasStation.add(new Info(a, b));
        }

        PriorityQueue<Integer> fuel = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int visit=0;
        while (P < L) {

            while (!gasStation.isEmpty() && P >= gasStation.peek().dist) {
                Info now = gasStation.poll();
                fuel.add(now.amount);

                if (fuel.isEmpty()) {
                }
            }
        }
    }
}
