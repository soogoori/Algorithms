package BOJ.Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {

    static int N, M, result;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0,};

    static class Info{
        int x, y;
        int dist;

        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static void bfs(int x, int y){
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(x, y, 0));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i]+ now.x;
                int ny = dy[i] + now.y;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny]) {
                    if (map[nx][ny] == 'L') {
                        visit[nx][ny] = true;
                        queue.add(new Info(nx, ny, now.dist+1));
                        result = Math.max(result, now.dist+1);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new char[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    visit = new boolean[N][M];
                    bfs(i, j);
                }
            }
        }
        System.out.println(result);
    }
}
