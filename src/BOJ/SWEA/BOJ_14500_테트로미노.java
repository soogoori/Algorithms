package BOJ.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {

    static int N, M; // N = 세로, M = 가로
    static int[][] num;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    // 'ㅗ'일 때 좌표 (ㅜ,ㅗ,ㅏ,ㅓ)
    static int[][] ox = {{0,0,0,1}, {0,0,0,-1}, {0,1,2,1}, {0,1,2,1}}; // 세로
    static int[][] oy = {{0,1,2,1}, {0,1,2,1}, {0,0,0,1}, {0,0,0,-1}}; // 가로
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;

    // 'ㅗ' 모양 제외 모두 가능
    static void dfs(int x, int y, int depth, int sum){

        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny]) {
                visit[nx][ny]=true;
                dfs(nx, ny, depth + 1, sum + num[nx][ny]);
                visit[nx][ny] = false;
            }
        }
    }

    // 'ㅗ' 모양 확인하기
    //'+' 에서 날개 하나 빼기(최소인 날개 빼면 됨)
    static void exception(int x, int y) {

        int w=4;
        int min = Integer.MAX_VALUE;
        int sum = num[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (w <= 2) {
                return;
            }

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                w--;
                continue;
            }

            min = Math.min(min, num[nx][ny]);
            sum += num[nx][ny];
        }

        if (w == 4) {
            sum-=min;
        }
        max = Math.max(sum, max);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 0, 0);
                exception(i, j);
            }
        }
        bw.write(max+ " ");

        bw.flush();
        bw.close();
    }
}
