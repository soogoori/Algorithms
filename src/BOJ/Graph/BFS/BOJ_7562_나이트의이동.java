package BOJ.Graph.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동{

    static int I;
    static int[] dx = {-1, 1, 2, -2, -1, 1, 2, -2}; // 가로 이동
    static int[] dy = {2, -2, 1, -1, -2, 2, -1, 1}; // 세로 이동
    static boolean[][] visit;
    static int[][] knight;
    static int rx, ry;

    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(x, y));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            if (now.y == ry && now.x == rx) {
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < I && ny < I && !visit[nx][ny]) {
                    if (knight[nx][ny] == 0) {
                        visit[nx][ny]=true;
                        queue.add(new Info(nx, ny));
                        knight[nx][ny] = knight[now.x][now.y] +1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            I = Integer.parseInt(br.readLine());
            knight = new int[I][I];
            visit = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            visit[x1][y1] = true;
            st = new StringTokenizer(br.readLine());
            rx = Integer.parseInt(st.nextToken());
            ry = Integer.parseInt(st.nextToken());

            bfs(x1, y1);
            System.out.println(knight[rx][ry]);
        }
    }
}
