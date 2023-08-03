package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * bfs
 */
public class BOJ_2583_영역구하기_dfs {

    static int N, M, K;
    static boolean[][] area;
    static boolean[][] visit;
    static int size;
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

    static void dfs(int x, int y) {
        visit[x][y] = true;
        size=1;

        if (x == M - 1 || y == N - 1) {

        }
        for (int i = 0; i < 4; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (!visit[nx][ny] && !area[nx][ny]) {
                    visit[nx][ny]=true;
                    dfs(nx, ny);
                    size++; //영역의 넓이
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
                    dfs(i, j);
                    ans.add(size);
                }
            }
        }

        System.out.println(ans.size());
        Collections.sort(ans);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }
}
