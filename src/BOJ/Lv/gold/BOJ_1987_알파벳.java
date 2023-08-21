package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DFS
 * 백트래킹
 */
public class BOJ_1987_알파벳 {

    static int R, C;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] board;
    static boolean[] visit;
    static int max=Integer.MIN_VALUE;

    public static void dfs(int x, int y, int passCnt){

        visit[board[x][y]] = true;
        max = Math.max(passCnt, max);

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visit[board[nx][ny]]) {
                dfs(nx, ny, passCnt + 1);
                visit[board[nx][ny]] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        visit = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        // 깊이 우선 탐색 DFS
        dfs(0, 0, 1);

        System.out.println(max);
    }
}
