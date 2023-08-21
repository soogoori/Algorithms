package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최단 거리 중 최댓값 구하기
 * BFS
 */
public class BOJ_2589_보물섬 {

    static int N, M;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer;

    static class Info{
        int x, y;
        int dist;

        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static void bfs(Info info){
        Queue<Info> queue = new LinkedList<>();
        queue.add(info);
        visit[info.x][info.y] = true;

        while (!queue.isEmpty()) {
            Info next = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny]=='L') {
                    if (!visit[nx][ny]) {
                        visit[nx][ny]=true;
                        queue.add(new Info(nx, ny, next.dist + 1));
                        answer = Math.max(answer, next.dist+1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String lw = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = lw.charAt(j);
            }
        }

        answer=0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    visit = new boolean[N][M];
                    bfs(new Info(i, j, 0));
                }
            }
        }
        System.out.println(answer);
    }
}
