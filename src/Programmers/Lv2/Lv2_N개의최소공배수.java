package Programmers.Lv2;

/**
 * 유클리드 호제법 + 최대공약수 + 최소공배수
 */
public class Lv2_N개의최소공배수 {
    public static void main(String[] args){

    }
    public static int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }

    public static int gcd(int a, int b){

        if (a %  b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }
}
