package BOJ.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {

    static int N, M;
    static int max = Integer.MIN_VALUE;
    static int[][] lab;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //DFS
    static void makeWall(int depth){

        if (depth == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] ==0) {
                    lab[i][j]=1;
                    makeWall(depth + 1);
                    lab[i][j]=0;
                }
            }
        }
    }

    // BFS
    static void spreadVirus(){

        Queue<Info> queue = new LinkedList<>();
        int[][] virusMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = lab[i][j];
                if (virusMap[i][j] == 2) {
                    queue.add(new Info(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && virusMap[nx][ny]==0) {
                    virusMap[nx][ny] = 2;
                    queue.add(new Info(nx, ny));
                }
            }
        }

        int cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 0) {
                  cnt++;
                }
            }
        }

        max = Math.max(cnt, max);

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);
        bw.write(max + " ");
        bw.flush();
        bw.close();
    }
}
