package Programmers.Lv1;

import java.util.ArrayList;
import java.util.Collections;

public class Lv1_나누어떨어지는숫자배열 {

    public int[] solution(int[] arr, int divisor) {

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0){
                ans.add(arr[i]);
            }
        }

        if(ans.size()==0){
            ans.add(-1);
        }else{
            Collections.sort(ans);
        }

        int[] answer = new int[ans.size()];

        for(int i=0; i<answer.length; i++){
            answer[i] = ans.get(i);
        }

        return answer;
    }
}
