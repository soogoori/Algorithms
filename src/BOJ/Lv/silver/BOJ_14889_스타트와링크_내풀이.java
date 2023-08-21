package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크_내풀이 {

    static int N;
    static int[][] team;
    static boolean[] visit;


    // 조합 이용해서 스타트와 링크 구성원 고르기
    static void combi(int idx, int depth) {

        if (depth == N / 2) {
            getDiff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combi(idx + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    // 스타트와 링크 능력치 탐색 & 차이 비교
    static void getDiff(){

        int start = 0, link=0;

        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {

            }
        }

    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        team = new int[N + 1][N + 1];
        visit = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(1, 0);


    }

}
