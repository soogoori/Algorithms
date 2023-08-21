package BOJ.Graph.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS
 */
public class BOJ_2178_미로탐색 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs() {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(0, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny]) {
                    if (maze[nx][ny] !=0) {
                        visit[nx][ny]=true;
                        queue.add(new Info(nx, ny));
                        maze[nx][ny] = maze[now.x][now.y]+1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j)-'0';
            }
        }
        visit[0][0]=true;
        bfs();
        bw.write(String.valueOf(maze[N-1][M-1]));
        bw.flush();
        bw.close();
    }
}
