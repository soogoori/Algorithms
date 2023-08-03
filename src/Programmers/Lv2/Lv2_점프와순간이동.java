package Programmers.Lv2;

public class Lv2_점프와순간이동 {
    public static void main(String[] args) {
        int n=6;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 != 0) {
                ans++;
            }
            n/=2;
        }
        return ans;
    }
}
