package Programmers.Lv2;

public class Lv2_카펫 {
    public static void main(String[] args){
        int brown = 8;
        int yellow = 1;

        solution(brown, yellow);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown+yellow;

        for (int i = 1; i <= yellow/2+1; i++) {
            if (yellow % i == 0) {
                if ((i + 2) * (yellow / i + 2) == sum) {
                    answer[0] = Math.max((i + 2), (yellow / i + 2));
                    answer[1] = Math.min((i + 2), (yellow / i + 2));
                    break;
                }
            }
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
        return answer;
    }
}
