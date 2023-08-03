package Programmers.Lv2;

public class Lv2_n2배열자르기 {
    public static void main(String[] args){
        int n=4;
        long left=7;
        long right=14;

        solution(n, left, right);
    }

    public static int[] solution(int n, long left, long right) {
        int len = (int) (right - left)+1;

        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = Math.max((int) (left % n) + 1, (int) (left / n)+1);
            left++;
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
        return answer;
    }
}
