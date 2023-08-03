package Programmers.Lv1;

import java.util.Arrays;

public class Lv1_가장가까운같은글자 {
    public static void main(String[] args){
        String s = "banana";
        solution(s);
    }
    public static void solution(String s) {
        int[] answer = new int[s.length()];
        int[] alpha = new int[27];
        Arrays.fill(alpha, -1);
        for(int i=0; i<s.length(); i++){
            System.out.println((int)s.charAt(i)-97);

            if(alpha[(int)s.charAt(i)-97]<0){
                answer[i] = -1;
                alpha[(int)s.charAt(i)-97] = i;
            }else{
                answer[i] = i-alpha[(int)s.charAt(i)-97];
                alpha[(int)s.charAt(i)-97] = i;
            }
        }

        for (int i : answer) {
            System.out.print(i+ " ");
        }
    }
}
