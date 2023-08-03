package Programmers.Lv2;

import java.util.HashSet;

public class Lv2_소수찾기 {
    static boolean[] isPrime = new boolean[10000000];
    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        String numbers = "17";

        System.out.println(solution(numbers));
    }
    public static int solution(String numbers) {
        int answer = 0;

        arr = new char[numbers.length()];
        visit = new boolean[numbers.length()];

        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        isItPrime();

        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }

        makeNum("", 0);
        answer = set.size();
        return answer;
    }

    // 숫자 만들기 로직 -> DFS
    public static void makeNum(String str, int idx) {

        int num;

        if (str != "") {
            num = Integer.parseInt(str);
            if (isPrime[num]) {
                set.add(num);
            }
        }

        if(idx==arr.length) return;

        for (int i = 0; i < arr.length; i++) {
            if(visit[i])    continue;
            visit[i] = true;
            makeNum(str + arr[i], idx + 1);
            System.out.println("result : " + str+arr[i]);
            visit[i] = false;
        }
    }

    // 소수 판별 로직
    public static void isItPrime(){
        for (int i = 2; i*i <= isPrime.length; i++) {
            if(isPrime[i]==true){
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false; // 배수들은 소수가 아님.
                }
            }
        }
    }
}
