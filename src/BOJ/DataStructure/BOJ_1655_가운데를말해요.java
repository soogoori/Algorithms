package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * 우선순위 큐
 */
public class BOJ_1655_가운데를말해요 {

    /**
     * 우선순위 큐 2개를 이용해서 중앙값을 찾는다 ..
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> minPq = new PriorityQueue<>(); // 작은 값이 우선순위
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(((o1, o2) -> o2-o1)); // 큰 값이 우선순위

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (minPq.size() == maxPq.size()) maxPq.offer(num);
            else minPq.offer(num);

            if (!minPq.isEmpty() && !maxPq.isEmpty()) {
                // maxPq의 가장 상위값 = 그중 가장 최댓값 / minPq의 가장 상위값 = 그중 가장 최솟값
                System.out.println("minPq.peek() = " + minPq.peek());
                System.out.println("maxPq.peek() = " + maxPq.peek());
                if(minPq.peek()<maxPq.peek()) {
                    int tmp = minPq.poll();
                    minPq.add(maxPq.poll());
                    maxPq.add(tmp);
                }
            }
            System.out.println(maxPq.peek());
        }
    }
}
