package Programmers.Lv2;

import java.util.Arrays;

public class Lv2_요격시스템 {

    public static void main(String[] args){
        int[][] targets = {
                {4,5},{4,8}, {10,14}, {11,13}, {5,12},
                {3,7}, {1,4}};

        System.out.println(solution(targets));
    }
    public static int solution(int[][] targets) {

        int answer = 0;
        int end =0;


        Arrays.sort(targets, ((o1, o2) -> o1[0] - o2[0]));

        for (int i = 0; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];

            if (s < end) {
                continue;
            } else {
                end = e;
                answer++;
            }
        }
        return answer;
    }
}
