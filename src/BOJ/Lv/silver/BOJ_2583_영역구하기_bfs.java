package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * bfs
 */
public class BOJ_2583_영역구하기_bfs {

    static int N, M, K;
    static boolean[][] area;
    static boolean[][] visit;
    static int cnt, size;
    static int[] mx = {0, -1, 1, 0};
    static int[] my = {1, 0, 0, -1};
    static List<Integer> ans;


    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int a, int b) {
        size=1;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(a, b));
        visit[a][b] = true;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + mx[i];
                int ny = now.y + my[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (!visit[nx][ny] && !area[nx][ny]) {
                        visit[nx][ny]=true;
                        size++; // 영역의 넓이
                        queue.add(new Info(nx, ny));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //세로
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        area = new boolean[M][N];
        visit = new boolean[M][N];
        ans= new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    area[j][k] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && !area[i][j]) {
                    bfs(i, j);
                    ans.add(size);
                    cnt++; // 존재하는 영역의 개수
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(ans);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }
}
