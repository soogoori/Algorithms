package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 아직 미해결..
 */
public class BOJ_14940_쉬운최단거리 {

    static int n, m;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int startx, starty;
    static boolean[][] visit;

    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(){
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(startx, starty));

        while (!queue.isEmpty()) {
            Info next = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i]+ next.x;
                int ny = dy[i] + next.y;

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny] && map[nx][ny]==1) {
                    map[nx][ny] = map[next.x][next.y]+1;
                    queue.add(new Info(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startx=i;
                    starty=j;
                }
            }
        }
        bfs();

        // 0 = 갈 수 없음. 1 = 갈 수 있음. 2 = 목표지점
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    System.out.print(map[i][j] - 2 + " ");
                } else {
                    System.out.print(0+ " ");
                }
            }
            System.out.println();
        }
    }
}
