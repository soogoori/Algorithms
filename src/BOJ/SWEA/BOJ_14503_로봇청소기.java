package BOJ.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * DFS 이용하기
 */
public class BOJ_14503_로봇청소기 {

    static int N, M; // N=세로, M=가로
    static int r,c,d; // r=세로, c=가로, d=방향
    static int cnt; // 청소하는 칸의 개수
    static int[][] room;

    /*static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};*/

    static int[] dx = {-1, 0, 1, 0}; // 북동남서 -> 0123
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y, int dir) {

        room[x][y] = -1;// 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소

        // 주변 4칸 탐색
        // 북→서→남→동 = 0→3→2→1
        for (int i = 0; i < 4; i++) {
            dir = (dir+3)%4; // 반시계방향
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (room[nx][ny] == 0) { // 청소되지 않은 빈칸이 있다면
                    cnt++;
                    dfs(nx, ny, dir);
                    return;
                }
            }
        }

        // 0->2(북->남), 3->1(서->동), 2->0(남->북), 1->3(동->서)
        int back = (dir+2)%4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if (bx >= 0 && by >= 0 && bx < N && by < M && room[bx][by] != 1) {
            dfs(bx, by, dir); // 바라보는 방향을 유지한 채로 한 칸 후진
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt=1;
        dfs(r, c, d);

        bw.write(cnt + " ");
        bw.flush();
        bw.close();
    }
}
