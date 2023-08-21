package BOJ.Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BFS로 풀었다.
 */
public class BOJ_2583_영역구하기 {

    static int M,N,K;
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Integer> answer;

    public static class Info{
        int x, y;
        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int a, int b){
        int size = 1;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(a, b));
        visit[a][b] = true;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visit[nx][ny]) {
                    if (area[nx][ny] == 0) {
                        queue.add(new Info(nx, ny));
                        visit[nx][ny]=true;
                        size++;
                    }
                }
            }
        }
        answer.add(size);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        K = Integer.parseInt(st.nextToken()); // 직사각형 개수

        area = new int[M+1][N+1];
        visit = new boolean[M+1][N+1];
        answer = new ArrayList<>();
        int x1, x2, y1, y2;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    area[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && area[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.print(integer+ " ");
        }
    }
}
