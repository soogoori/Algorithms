package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1205_등수구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long newScore = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] scoreList = new int[P];
        int[] rankList = new int[P];
        int repeat=0;

        for (int i = 0; i < P; i++) {
            rankList[i] =1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scoreList[i] = Integer.parseInt(st.nextToken());
            if (scoreList[i] != scoreList[i - 1] && i>0) {
                rankList[i] += rankList[i - 1];
            }else if(scoreList[i] == scoreList[i - 1] && i>0){
                rankList[i] = rankList[i - 1];
                repeat++;
            }
        }

        if ((N==P) && newScore<=scoreList[N-1]) {
            System.out.println(-1);
            return;
        }


    }
}
