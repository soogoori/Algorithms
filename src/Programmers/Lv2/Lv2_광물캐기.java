package Programmers.Lv2;

import java.util.Arrays;

public class Lv2_광물캐기 {
    public static void main(String[] args){
        int[] picks = {0, 1, 1};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        System.out.println(solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 돌로 캤을 때 가장 피로도가 높은 것을 다이아 곡괭이로 캐야 함
        int cnt = Math.min(minerals.length, picks[0] + picks[1] + picks[2]);

        int[][] section = new int[cnt][3]; // 광물별 피로도

        int dt=0, it=0, st=0;

        for (int i = 0; i < minerals.length; i++) {
            if (i / 5 == cnt) {
                break;
            }

            for (int j = i; j < i + 5; j++) {
                String m = minerals[j];
                if (m.equals("diamond")) {
                    dt +=1;
                    it+=5;
                    st+=25;
                } else if (m.equals("iron")) {
                    dt += 1;
                    it += 1;
                    st += 5;
                } else {
                    dt +=1;
                    it+=1;
                    st+=1;
                }
                if (j == minerals.length - 1) {
                    break;
                }
            }

            section[i/5][0] =dt;
            section[i/5][1] =it;
            section[i/5][2] =st;

            dt=it=st=0;
        }

        Arrays.sort(section, (o1, o2) -> (o1[2] - o2[2]));

        for (int i = 0; i < cnt; i++) {
            if (picks[0] != 0) {
                answer += section[i][0];
                picks[0]--;
            }
        }
        return answer;
    }
}
