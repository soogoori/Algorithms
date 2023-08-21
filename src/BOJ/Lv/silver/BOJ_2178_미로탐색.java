package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최단거리, 경로는 BFS 사용해서 푸는 것이 효율적임
 * DFS는 시간초과 발생
 */
public class BOJ_2178_미로탐색 {

    static int N,M;
    static int[][] maze;
    static int[][] dist;
    static int[] x = {0, 0, -1, 1};
    static int[] y = {1, -1, 0, 0};

    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int dx, int dy){

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(dx, dy));
        dist[dx][dy] =0;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + x[i];
                int ny = now.y + y[i];

                if (nx <= N && ny <= M && nx > 0 && ny > 0) {
                    if (dist[nx][ny]==-1 && maze[nx][ny]==1) {
                        dist[nx][ny] = dist[now.x][now.y] + 1;
                        queue.add(new Info(nx, ny));
                    }
                }
            }
        }
        System.out.println(dist[N][M]+1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];


        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = line.charAt(j-1)-'0';
                dist[i][j] = -1;
            }
        }

        bfs(1, 1);
    }
}
