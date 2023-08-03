package Programmers.Lv1;

public class Lv1_정수제곱근판별 {
    public static void main(String[] args){
        long n = 121;
        System.out.println(solution(n));
    }

    public static long solution(long n) {
        long answer = 0;
        long l=0;

        while(l*l<=n){
            if(l*l==n){
                return answer = (l+1)*(l+1);
            }else{
                ++l;
            }
        }
        answer = -1;
        return answer;
    }
}
