package Programmers.Lv2;

import java.util.*;

public class Lv2_귤고르기 {
    public static void main(String[] args) {

        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
        int k=2;
        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        Arrays.sort(tangerine);
        Map<Integer, Integer> tanger = new HashMap<>();

        int cnt=1;

        for (int i = 1; i < tangerine.length; i++) {
            if (tangerine[i - 1] == tangerine[i]) {
                cnt++;
            } else {
                tanger.put(tangerine[i-1], cnt);
                cnt=1;
            }
        }
        tanger.put(tangerine[tangerine.length - 1], cnt);


        List<Integer> tangerList = new ArrayList<>(tanger.values());
        Collections.sort(tangerList, (o1, o2) -> Integer.compare(o2, o1));

        int sum=0;
        for (Integer integer : tangerList) {
            if (sum < k) {
                sum += integer;
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}
