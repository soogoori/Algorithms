package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Lv2_튜플 {
    public static void main(String[] args) throws Exception {
        String s= "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        solution(s);

    }

    public static int[] solution(String s) {

        ArrayList<Integer> answerArr = new ArrayList<>();

        s = s.substring(1, s.length() - 1);

        System.out.println("s = " + s);
        s = s.replaceAll("\\{", "");

        String[] str = s.split("},");
        str[str.length - 1] = str[str.length - 1].substring(0, str[str.length - 1].length() - 1);

        for (String s1 : str) {
            System.out.println("s1 = " + s1);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });


        for (String s1 : str) {
            String[] temp = s1.split(",");

            for (int i = 0; i < temp.length; i++) {
                int n = Integer.parseInt(temp[i]);

                if (!answerArr.contains(n)) {
                    answerArr.add(n);
                }
            }
        }

        int[] answer = new int[answerArr.size()];

        for (int i = 0; i < answerArr.size(); i++) {
            answer[i] = answerArr.get(i);
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
        return answer;
    }
}
