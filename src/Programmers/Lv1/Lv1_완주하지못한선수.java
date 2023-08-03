package Programmers.Lv1;

import java.util.HashMap;

/**
 * 해시 이용
 */
public class Lv1_완주하지못한선수 {
    public static void main(String[] args) throws Exception{

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            if(map.get(p)==null) {
                map.put(p, 1);
            }else { //이름중복일경우
                map.put(p, map.get(p)+1);
            }
        }
        /*for (String key: map.keySet()){
            System.out.println("{" + key+ " => " + map.get(key) + "}");
        }*/

        for (String p : completion) {
            if(map.get(p)!=0) {
                map.put(p, map.get(p)-1);
            }
        }

        for (String key : map.keySet()) {
            if(map.get(key)!=0) {
                return key;
            }
        }
        return answer;
    }
}
