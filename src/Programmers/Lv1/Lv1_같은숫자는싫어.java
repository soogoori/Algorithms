package Programmers.Lv1;

import java.util.ArrayList;

public class Lv1_같은숫자는싫어 {
    public static void main(String[] args){
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        solution(arr);

    }

    public static int[] solution(int[] arr) {

        ArrayList<Integer> arrList = new ArrayList<>();

        arrList.add(arr[0]);

        for(int i=1; i<arr.length; i++){

            if(arr[i-1]==arr[i]){
                continue;
            }else{
                arrList.add(arr[i]);
            }
        }
        int[] answer = new int[arrList.size()];

        for(int i=0; i<arrList.size(); i++){
            answer[i] = arrList.get(i);
        }
        for (int i : answer) {
            System.out.println("i = " + i);
        }
        return answer;
    }
}
