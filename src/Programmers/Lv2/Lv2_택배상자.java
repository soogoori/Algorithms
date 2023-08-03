package Programmers.Lv2;

import java.util.Stack;

public class Lv2_택배상자 {
    public static void main(String[] args) throws Exception {
        int[] order = {5, 4, 3,2, 1};
        System.out.println(solution(order));
    }

    public static int solution(int[] order) {
        int answer = 0;
        int idx=0;
        Stack<Integer> subBelt = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            boolean flag = false;

            // 꺼낸 택배상자와 순서가 맞을 때
            if (i == order[idx]) {
                idx++;
                flag= true;
                answer++;
            }
            // 꺼낸 택배상자와 순서가 맞지 않지만 보조 컨테이너에 존재할 때
            while (!subBelt.isEmpty() && order[idx] == subBelt.peek()) {
                idx++;
                answer++;
                flag = true;
            }

            // 순서도 맞지 않고 보조 컨테이너에 없을 때
            if (!flag) {
                subBelt.add(i);
            }


        }


        return answer;
    }
}
