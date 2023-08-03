package Programmers.Lv2;

import java.util.ArrayList;

public class Lv2_캐시 {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju",
                "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        // 참조하는 값이 이미 페이지에 존재하면 Cache Hit = 1
        // 나머지 상황들이 존재하지 않을때 새로 교체 됨 → Cache Miss = 5
        int answer = 0;

        ArrayList<String> cache = new ArrayList<>();

        if (cacheSize == 0) {
            return answer = cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();

            if (cache.contains(cities[i])) {
                cache.remove(cities[i]);
                cache.add(cities[i]);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                    cache.add(cities[i]);
                } else {
                    cache.add(cities[i]);
                }
                answer+=5;
            }
        }

        return answer;
    }
}
