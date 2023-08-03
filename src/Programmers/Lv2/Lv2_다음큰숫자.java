package Programmers.Lv2;

public class Lv2_다음큰숫자 {
    public static void main(String[] args) {
        int n=15;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;

        int cnt = Integer.bitCount(n);

        while (true) {
            n++;
            if (Integer.bitCount(n)==cnt) {
                answer=n;
                break;
            }
        }
        return answer;
    }
}
