package Programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 어렵다.
 */
public class Lv2_다리를지나는트럭 {
    public static void main(String[] args){
        int bridge_length=2;
        int weight=10;
        int[] truck_weights = {7, 4, 5, 6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx =0;
        int sum = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        while (idx < truck_weights.length) {
            answer++;
            sum -= queue.poll();

            if (sum + truck_weights[idx] <= weight) {
                queue.add(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else {
                queue.add(0);
            }
        }

        return bridge_length+answer;
    }
}
