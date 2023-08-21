package Programmers;

public class LG {
    public static void main(String[] args){
        int n=400;
        int m =500000;

        System.out.println(solution(n,m));
    }

    public static int solution(int n, int m){
        int answer=0;

        for (int i = n; i <= m; i++) {
            if (isPalindrome(i)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPalindrome(int n){
        String num = String.valueOf(n);
        if (num.length() == 1) {
            return true;
        }else{
            int len = num.length();
            int s=0, l=len-1;

            while(s<l) {
                if (num.charAt(s) == num.charAt(l)) {
                    s++;
                    l--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
