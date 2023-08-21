package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {

    static int n, m;
    static int[][] picture;
    static boolean[][] visit;
    static int[] x = {0, 0, 1, -1};
    static int[] y = {1, -1, 0, 0};
    static int maxPic, max;

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
        visit[dx][dy] = true;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + x[i];
                int ny = now.y + y[i];

                if (nx > 0 && ny > 0 && nx <= n && ny <= m) {
                    if (!visit[nx][ny] && picture[nx][ny] == 1) {
                        maxPic++;
                        visit[nx][ny] = true;
                        queue.add(new Info(nx,ny));
                    }
                }
            }
        }
        System.out.println("maxPic = " + maxPic);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        picture = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(picture[i][j]==1 && !visit[i][j]){
                    maxPic=1;
                    bfs(i, j);
                    max = Math.max(maxPic, max);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }
}
