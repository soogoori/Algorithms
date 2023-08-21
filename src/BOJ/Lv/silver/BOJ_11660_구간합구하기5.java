package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 미해결 → 시간초과..ㅜ
 * dp 사용해서 해결하기 !
 */
public class BOJ_11660_구간합구하기5 {

    static int N, M;
    static int[][] graph;
    static int[] sectionSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        sectionSum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                sectionSum[i] += graph[i][j];
            }
        }

        int x1, x2, y1, y2;
        for (int j = 1; j <= M; j++) {
            int answer=0;
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int k = x1; k <= x2; k++) {
                answer += sectionSum[k];
            }

            for (int l = y1-1; l >=1; l--) {
                answer -= graph[x1][l];
                if(x1!=x2)  answer -= graph[x2][l];
            }
            for (int m = y2+1; m<=N; m++) {
                answer -= graph[x2][m];
                if(x1!=x2)  answer -= graph[x1][m];
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
