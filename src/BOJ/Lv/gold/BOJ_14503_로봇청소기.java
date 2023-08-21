package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 어렵다....
 */
public class BOJ_14503_로봇청소기 {

    static int N, M, forward;
    static int[][] room;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서
    static int[] dy = {0, 1, 0, -1};
    static int cnt;

    // direction : 0→북→후진=아래로 1→동→후진=왼쪽으로 2→남→후진=위로 3→서→후진=오른쪽으

    public static void dfs(int x, int y, int direction) {

        room[x][y] = -1; // 청소 완료.

        // 현재 위치에서 현재 방향을 기준으로 왼쪽 (반시계방향)부터 차례대로 탐색 진행
        // 북→서→남→동 = 0→3→2→1
        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx >= 0 && ny >= 0 && ny < M && nx < N) {
                if (room[nx][ny] == 0) { // 청소되지 않은 빈칸이 있는 경우
                    cnt++;
                    dfs(nx, ny, direction);
                    return;
                }
            }
        }

        // 모두 청소 완료 or 벽인 경우
        int back = (direction + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if (bx >= 0 && by >= 0 && by < M && bx < N && room[bx][by] != 1) {
            dfs(bx, by, direction);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int ni = Integer.parseInt(st.nextToken());
        int nj = Integer.parseInt(st.nextToken());
        forward = Integer.parseInt(st.nextToken());
        cnt=1;
        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(ni, nj, forward);
        System.out.println("cnt = " + cnt);
    }
}
