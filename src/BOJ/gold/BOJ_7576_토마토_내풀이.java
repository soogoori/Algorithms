package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 나 혼자 못 품.
 */
public class BOJ_7576_토마토_내풀이 {

    static int M, N;
    static int[][] box;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Info> queue = new LinkedList<>();
    static int max=Integer.MIN_VALUE;

    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(){

        while (!queue.isEmpty()) {
            Info next = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + next.x;
                int ny = dy[i] + next.y;

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = box[next.x][next.y]+1;
                        queue.add(new Info(nx, ny));
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    max = -1;
                    break;
                } else {
                    max = Math.max(box[i][j], max);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new Info(i, j));
                }
            }
        }
        bfs();

        System.out.println(max-1);
    }
}
