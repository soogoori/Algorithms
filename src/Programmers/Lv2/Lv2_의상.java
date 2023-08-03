package Programmers.Lv2;

import java.util.HashMap;
import java.util.Iterator;

public class Lv2_의상{
    public static void main(String[] args){
        String[][] clothes= {{"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {

        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < clothes.length; i++){
            hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1], 0)+1);
        }

        Iterator<Integer> iterator = hash.values().iterator();
        int answer = 1;

        while (iterator.hasNext()) {
            answer*=iterator.next().intValue()+1;
        }

        return answer-1;
    }
}

