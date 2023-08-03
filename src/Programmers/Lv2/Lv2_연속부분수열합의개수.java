package Programmers.Lv2;

import java.util.HashSet;
import java.util.Set;

public class Lv2_연속부분수열합의개수 {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};

        System.out.println(solution(elements));
    }

    public static int solution(int[] elements) {
        int answer = 0;
        Set<Integer> numSet = new HashSet<>(); // 중복 제거

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum=0;
                for (int k = j; k < j+i; k++) {
                    sum+=elements[k% elements.length];
                }
                numSet.add(sum);
            }
        }
        answer = numSet.size();
        return answer;
    }

}
