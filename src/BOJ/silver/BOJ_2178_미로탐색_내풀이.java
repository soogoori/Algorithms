package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색_내풀이 {

    static int N,M;
    static int[][] maze;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] dist;

    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(0, 0));
        dist[0][0]++;

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            int x = info.x;
            int y = info.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == 1 && dist[nx][ny]==-1) {
                    queue.add(new Info(nx, ny));
                    dist[nx][ny] = dist[x][y]+1;
                }
            }
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j)-'0';
                dist[i][j] = -1;
            }
        }

        bfs();

        System.out.println(dist[N-1][M-1]+1);

    }
}
