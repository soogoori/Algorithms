package Programmers.Lv1;

import java.util.Arrays;

public class Lv1_명예의전당_1 {
    public static void main(String[] args){

        int[] score= {10, 100, 20, 150, 1, 100, 200};
        solution(3, score);
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        answer[0]= score[0];
        answer[1] = Math.min(score[0], score[1]);

        for(int i=2; i<score.length; i++){
            Arrays.sort(score, 0, i+1);
            System.out.println(Arrays.toString(score));
            if(k-1>=i){
                answer[i] = score[0];
            }else{
                answer[i] = score[i-k+1];
            }
        }
        return answer;
    }
}
