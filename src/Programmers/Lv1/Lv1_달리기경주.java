package Programmers.Lv1;

import java.util.HashMap;


public class Lv1_달리기경주 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        solution(players, callings);

    }

    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        HashMap<String, Integer> runner = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            runner.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int idx = runner.get(callings[i]);
            String temp = players[idx - 1];
            players[idx-1] = players[idx];
            players[idx] = temp;

            runner.replace(callings[i], idx - 1);
            runner.replace(temp, idx);
        }

        for (int i = 0; i < players.length; i++) {
            answer[i] = players[i];
        }


        for (String s : answer) {
            System.out.println("s = " + s);
        }
        return answer;
    }


    /**
     * 시간 초과 남..
     */
    /*public static String[] solution(String[] players, String[] callings) {
        //String[] answer = new String[players.length];

        for (int i = 0; i < callings.length; i++) {
            int idx = Arrays.asList(players).indexOf(callings[i]);
            String temp = players[idx - 1];
            players[idx - 1] = callings[i];
            players[idx] = temp;
        }

        for (String s : players) {
            System.out.println("s = " + s);
        }

        return players;
    }*/
}
