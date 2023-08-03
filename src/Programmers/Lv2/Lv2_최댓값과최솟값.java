package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Collections;

public class Lv2_최댓값과최솟값 {

    public static void main(String[] args) throws Exception {
        String s ="-1 -2 -3 -4";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";
        ArrayList<Long> arr = new ArrayList<>();

       String[] str = s.split(" ");

        for (int i= 0; i < str.length; i++) {
            arr.add(Long.parseLong(str[i]));
        }

        for (String s1 : str) {
            System.out.println("s1 = " + s1);
            arr.add(Long.parseLong(s1));
        }

        Collections.sort(arr);

        answer += arr.get(0) + " ";
        answer += arr.get(arr.size() - 1);

        return answer;
    }
}
