package Programmers.Lv2;

import java.util.*;

/**
 * Hash 사용
 */
public class Lv2_메뉴리뉴얼 {

    static List<String> answerList = new ArrayList<>();
    static Map<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args){
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        solution(orders, course);
    }
    public static String[] solution(String[] orders, int[] course) {

        // 1. orders 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // 2. 각 order 기준으로 course 길이만큼의 조합 만들기 
        for (int courseLen : course) {
            for (String order : orders) {
                combination("", order, courseLen);
            }
            if (!hashMap.isEmpty()) {
                List<Integer> cntList = new ArrayList<>(hashMap.values());
                int max = Collections.max(cntList);

                if (max > 1) {
                    for (String key : hashMap.keySet()) {
                        if (hashMap.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
                hashMap.clear();
            }
        }
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        for (String s : answer) {
            System.out.println("s = " + s);
        }
        return answer;
    }

    public static void combination(String order, String others, int count) {

        if (count == 0) {
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            return;
        }

        for (int i = 0; i < others.length(); i++) {
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
        }
    }
}
