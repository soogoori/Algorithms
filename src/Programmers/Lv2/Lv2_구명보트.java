package Programmers.Lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lv2_구명보트 {
    public static void main(String[] args){
        int[] people = {40,50,150,160};
        int limit=200;

        System.out.println(solution(people, limit));
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;

        if (people.length == 1) {
            return answer=1;
        }

        Arrays.sort(people);
        int sum=0;

        Deque<Integer> deq = new ArrayDeque<>();

        for (int i = 0; i < people.length; i++) {
            deq.add(people[i]);
        }

        while (!deq.isEmpty()) {
            sum=deq.peekFirst()+deq.peekLast();

            if (sum <= limit) {
                deq.pollFirst();
                deq.pollLast();
                answer++;
            } else {
                sum-=deq.pollLast();
                answer++;
            }
        }
        return answer;
    }
}
