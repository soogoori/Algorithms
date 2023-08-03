package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 조합 → 반복문 안에 재귀호출 → 백트래킹
 */
public class BOJ_14889_스타트와링크 {

    static int N;
    static int[][] startLink;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    static void combi(int idx, int depth){

        if (depth == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combi(i+1, depth+1);
                visit[i] = false;
            }
        }
    }

    // 두 팀의 능력치 차이 계산
    static void diff(){
        int start = 0;
        int link = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {
                    start += startLink[i][j];
                    start += startLink[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    link += startLink[i][j];
                    link += startLink[j][i];
                }
            }
        }
        int val = Math.abs(start - link);
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(min, val);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        startLink = new int[N][N];
        visit = new boolean[N];

        for (int i =0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j =0; j <N; j++) {
                startLink[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(min);
    }
}
