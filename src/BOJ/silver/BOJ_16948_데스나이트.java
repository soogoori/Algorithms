package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16948_데스나이트 {

    static int N;
    static int[][] board;
    static boolean[][] visit;
    static int r1, r2, c1, c2;
    static int[] mr = {-2, -2, 0, 0, 2, 2};
    static int[] mc = {-1, 1, -2, 2, -1, 1};

    static class Knight{
        int r, c, cnt;

        public Knight(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static void bfs(int r, int c){
        Queue<Knight> queue = new LinkedList<>();
        queue.add(new Knight(r, c, 0));

        visit[r][c] = true;

        while (!queue.isEmpty()) {
            Knight knight = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nr = knight.r + mr[i];
                int nc = knight.c + mc[i];

               /* if (nr <= 0 || nc <= 0 || nr >N || nc >N || visit[nr][nc]) continue;

                visit[nr][nc] = true;
                queue.add(new Knight(nr, nc, knight.cnt + 1));*/


               if(nr>=0 && nc>=0 && nr<=N && nc<=N && !visit[nr][nc]){
                    if (nr == r2 && nc == c2) {
                        System.out.println(knight.cnt+1);
                        return;
                    }

                    visit[nr][nc] = true;
                    queue.add(new Knight(nr, nc, knight.cnt+1));
                }

            }
        }
        System.out.println(-1);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs(r1, c1);
    }
}
