package Programmers.Lv2;

import java.util.Stack;

/**
 * stack 이용하기
 */
public class Lv2_뒤에있는큰수찾기 {

    public static void main(String[] args) throws Exception {

        int[] numbers = {2, 3, 3, 5};
        solution(numbers);
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> s = new Stack<>();

        for (int i = numbers.length-1; i >=0; i--) {

            while (!s.isEmpty()) {
                if (s.peek() > numbers[i]) {
                    answer[i] = s.peek();
                    break;
                }else{
                    s.pop();
                }
            }
            if (s.isEmpty()) {
                answer[i] = -1;
            }
            s.push(numbers[i]);
        }
        return answer;
    }
}
