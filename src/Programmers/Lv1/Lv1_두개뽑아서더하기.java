package Programmers.Lv1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Lv1_두개뽑아서더하기 {
    public static void main(String[] args){
        int[] numbers = {2,1,3,4,1};
        solution(numbers);
    }
    public static int[] solution(int[] numbers) {
        Set<Integer> numSet = new TreeSet<>();
        Arrays.sort(numbers);

        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                numSet.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = new int[numSet.size()];

        int i=0;
        for (Integer integer : numSet) {
            answer[i++] = integer;
        }
       /* for (int i1 : answer) {
            System.out.println("i1 = " + i1);
        }*/
        return answer;
    }
}
