package Programmers.Lv2;

/**
 * 완전탐색
 * 미해결
 */
public class Lv2_모음사전 {
    public static void main(String[] args){
        String word = "AAAE";
        System.out.println(solution(word));
    }
    public static int solution(String word) {
        int answer = 0;

        String alpha = "AEIOU";
        StringBuilder sb = new StringBuilder();

        while (!sb.equals(word)) {

            // AEIOU 순서대로
            for (int i = 0; i < alpha.length(); i++) {
                // 글자수
                for (int j = 1; j <= 5; j++) {

                }
            }

            answer++;
        }
        return answer;
    }
}
