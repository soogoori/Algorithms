package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  그리디 알고리즘
 *  우선순위 큐
 *  아니 이거 원리 어떻게 혼자 생각해....?
 */
public class BOJ_1202_보석도둑 {
    static int N, K;

    static class Info implements Comparable<Info>{
        int m, v;

        public Info(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Info o) {
            return this.m- o.m;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<Info> jewelry = new ArrayList<>();
        int[] bag = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelry.add(new Info(m, v));
        }
        // 무게 오름차순으로 정렬 -> 만일 무게가 같다면, 가격을 내림차순으로 정렬
        Collections.sort(jewelry);

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        // 가방 오름차순으로 정렬
        Arrays.sort(bag);

        long total=0;
        int idx=0;
        // 가격 내림차순으로 정렬
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);

        for (int i = 0; i < K; i++) {
            while (idx < N && jewelry.get(idx).m <= bag[i]) {
                Info now = jewelry.get(idx++);
                pq.add(new Info(now.m, now.v));
            }
            if(!pq.isEmpty()) total += pq.poll().v;
        }

        System.out.println(total);
    }
}
