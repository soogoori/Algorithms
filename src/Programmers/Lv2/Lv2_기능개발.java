package Programmers.Lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Lv2_기능개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        solution(progresses, speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();

        int[] complete = new int[progresses.length];

        for (int i = 0; i < complete.length; i++) {
            complete[i] = (int)Math.ceil(((double)100 - progresses[i])/speeds[i]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < complete.length; i++) {
            queue.add(complete[i]);
        }

        int cnt=1;
        int cmp = queue.poll();
        while (!queue.isEmpty()) {
            if (cmp >= queue.peek()) {
                cnt++;
                queue.poll();
            } else {
                answerList.add(cnt);
                cnt=1;
                cmp = queue.poll();
                System.out.println("cmp = " + cmp);
            }
        }
        answerList.add(cnt);

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
        return answer;
    }
}
