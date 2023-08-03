package Programmers.Lv2;
import java.util.PriorityQueue;

/**
 * 미해결
 */
public class Lv2_더맵게 {
    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K =7;

        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        int sum=0;
        while (sum < K && pq.size()>=2) {
            sum=pq.poll()+pq.poll()*2;
            pq.add(sum);
            answer++;
        }
        if (sum < K) {
            answer = -1;
        }
        return answer;
    }
}
