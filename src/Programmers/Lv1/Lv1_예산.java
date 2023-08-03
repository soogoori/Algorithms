package Programmers.Lv1;

import java.util.Arrays;

public class Lv1_예산 {
    public static void main(String[] args){
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;

        System.out.println(solution(d, budget));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        int sum=0;
        for(int i=0; i<d.length; i++){
            sum+=d[i];
            if (sum <= budget) {
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }
}
