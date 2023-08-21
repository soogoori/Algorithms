package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {

    static int N;
    static int maxHeight;
    static int[][] area;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;

    static void dfs(int x, int y, int nowHeight){

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
                if (area[nx][ny] > nowHeight && !visit[nx][ny]) {
                    dfs(nx, ny, nowHeight);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        area = new int[N + 1][N + 1];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, area[i][j]);
            }
        }

        int result =0;

        for (int i = 1; i <= maxHeight; i++) {
            int safeAreaCnt=0;
            visit = new boolean[N + 1][N + 1];

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (!visit[j][k] && area[j][k]>i){
                        dfs(j, k, i);
                        safeAreaCnt++;
                    }
                }
            }

            result = Math.max(result, safeAreaCnt);
        }

        System.out.println(result);
    }
}
