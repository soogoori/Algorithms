package Programmers.Lv1;

import java.util.HashMap;

public class Lv1_대충만든자판 {
    public static void main(String[] args) {
        String[] keymap = {"ABCE"};
        String[] targets = {"ABDE"};
        solution(keymap, targets);
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        HashMap<Character, Integer> alpha = new HashMap<>();

        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                if (alpha.get(s.charAt(i)) == null) {
                    alpha.put(s.charAt(i), s.indexOf(s.charAt(i))+1);
                }
                else{
                    if (alpha.get(s.charAt(i)) > s.indexOf(s.charAt(i))+1) {
                        alpha.put(s.charAt(i), s.indexOf(s.charAt(i))+1);
                    }
                }
            }
        }

        for (int j = 0; j < targets.length; j++) {
            for (int i = 0; i < targets[j].length(); i++) {
                if(alpha.get(targets[j].charAt(i))==null){
                    answer[j]=-1;
                    break;
                }else{
                    answer[j]+=alpha.get(targets[j].charAt(i));
                }
            }
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }

        return answer;
    }
}
