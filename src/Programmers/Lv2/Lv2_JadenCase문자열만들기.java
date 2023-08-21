package Programmers.Lv2;

public class Lv2_JadenCase문자열만들기 {
    public static void main(String[] args){
        String s = "3people unFollowed me";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (str[i].length() == 0) {
                answer += " ";
            } else {
                answer += str[i].substring(0, 1).toUpperCase();
                answer += str[i].substring(1).toLowerCase();

                answer += " ";
            }
        }

        if (s.substring(s.length() - 1).equals(" ")) {
            return answer;
        }
        return answer.substring(0, answer.length() - 1);
    }
}
