package Programmers.Lv1;

import java.util.HashMap;

public class Lv1_성격유형검사하기 {
    public static void main(String[] args) throws Exception {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};

        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";

        // 지표별 성격유형
        HashMap<String, Integer> charType = new HashMap<>();
        charType.put("R", 0); // 1번 지표
        charType.put("T", 0); // 1번 지표
        charType.put("C", 0); // 2번 지표
        charType.put("F", 0); // 2번 지표
        charType.put("J", 0); // 3번 지표
        charType.put("M", 0); // 3번 지표
        charType.put("A", 0); // 4번 지표
        charType.put("N", 0); // 4번 지표

        int score;
        String type, character;

        // survey의 첫번째 요소는 비동의, 두번째 요소는 동의
        for (int i = 0; i < survey.length; i++) {
            type = survey[i];
            if (choices[i] <= 3) { // 비동의
                character = String.valueOf(type.charAt(0));
                score = charType.get(character);
                charType.replace(character, score+Math.abs(choices[i]-4));
            } else if (choices[i] >= 5) { // 동의
                character = String.valueOf(type.charAt(1));
                score = charType.get(character);
                charType.replace(character, score+Math.abs(choices[i]-4));
            }
        }

        // 점수 비교 R ↔ T   C ↔ F   J ↔ M   A ↔ N

        if (charType.get("R") >= charType.get("T")) {
            answer += "R";
        }else   answer += "T";

        if (charType.get("C") >= charType.get("F")) {
            answer += "C";
        }else   answer += "F";

        if (charType.get("J") >= charType.get("M")) {
            answer += "J";
        }else   answer += "M";

        if (charType.get("A") >= charType.get("N")) {
            answer += "A";
        }else   answer += "N";

        return answer;
    }
}
