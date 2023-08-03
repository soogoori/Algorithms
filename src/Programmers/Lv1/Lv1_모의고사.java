package Programmers.Lv1;

import java.util.ArrayList;


public class Lv1_모의고사 {
    public static void main(String[] args){
        int[] answers = {1, 3, 2, 4, 2};
        solution(answers);


    }

    public static int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[3];
        int len1 = num1.length;
        int len2 = num2.length;
        int len3 = num3.length;


        for(int i=0; i<answers.length; i++){
            if(answers[i]==num1[i%len1])    cnt[0]++;
            if(answers[i]==num2[i%len2])    cnt[1]++;
            if(answers[i]==num3[i%len3])    cnt[2]++;
        }

        int max = 0;

        for(int i=0; i<3; i++){
            if(cnt[i]>=max){
                max = cnt[i];
            }
        }
        for(int i=0; i<3; i++){
            if(cnt[i]==max){
                answer.add(i);
            }
        }
        int[] ans = new int[answer.size()];

        for(int i=0; i<answer.size(); i++){
            ans[i] = answer.get(i)+1;
        }

        for(int i=0; i<ans.length; i++){
            System.out.println("ans = " + ans[i]);
        }

        return ans;
    }
}
