package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추_DFS {

    static int T;
    static int[][] land;
    static boolean[][] visit;
    static int[] x = {0, 0, 1, -1};
    static int[] y = {1, -1, 0, 0};
    static int M, N, K, X, Y;

    static void dfs(int dx, int dy){

        for (int i = 0; i < 4; i++) {
            int nx = dx + x[i];
            int ny = dy + y[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visit[ny][nx]) {
                if (land[ny][nx] == 1) {
                    visit[ny][nx]=true;
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            land = new int[N][M];
            visit = new boolean[N][M];

            int answer=0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());

                land[Y][X] = 1;
            }

            for (int k = 0; k < N; k++) {
                for (int l = 0; l < M; l++) {
                    if (!visit[k][l] && land[k][l]==1) {
                        visit[k][l]=true;
                        dfs(l, k);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
