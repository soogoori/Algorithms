package Programmers.Lv2;

import java.util.Stack;

/**
 * 스택 이용 -> 구현 어려움..ㅜ
 */
public class Lv2_주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        solution(prices);
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        // 끝까지 가격이 떨어지지 않은 것
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length-stack.peek()-1;
        }
        for (int i : answer) {
            System.out.println("i = " + i);
        }
        return answer;
    }
}
