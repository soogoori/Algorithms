package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cmp=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum=0, getNum=0;

        while (!pq.isEmpty()) {
            getNum = pq.poll();
            cmp = getNum + pq.poll();
            sum+= cmp;
            pq.add(cmp);
        }

        System.out.println(sum);

    }
}
