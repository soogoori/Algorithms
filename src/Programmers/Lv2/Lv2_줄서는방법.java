package Programmers.Lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * 정해진 자리에 맞는 숫자들 추측해서 풀어야 함.
 */
public class Lv2_줄서는방법 {
    public static void main(String[] args){
        int n = 4;
        int k = 15;

        System.out.println(solution(n, k));
    }
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long cnt=1;

        for (int i = 1; i <= n; i++) {
            list.add(i);
            cnt*=i;
        }
        k--;
        int idx =0;
        while (n > 0) {
            cnt/=n;
            answer[idx++] = list.get((int) (k / cnt));
            list.remove((int) (k / cnt));
            k%=cnt;
            n--;
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
        return answer;
    }
}
