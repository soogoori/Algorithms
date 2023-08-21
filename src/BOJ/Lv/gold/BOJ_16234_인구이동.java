package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS
 * 어렵다.. 역시 삼성...
 */
public class BOJ_16234_인구이동 {
    static int N, L, R;
    static int[][] A;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Info> arrayList; // 인구 이동이 필요한 경우
    static boolean[][] check;

    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(int x, int y){
        Queue<Info> queue = new LinkedList<>();
        arrayList = new ArrayList<>();

        queue.add(new Info(x, y));

        int population = A[x][y];

        while (!queue.isEmpty()) {

            Info now = queue.poll();
            check[now.x][now.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !check[nx][ny]) {
                    if (Math.abs(A[now.x][now.y] - A[nx][ny]) >= L ||
                            Math.abs(A[now.x][now.y] - A[nx][ny]) <= R) {
                        check[nx][ny] = true;
                        population+=A[nx][ny];
                        queue.add(new Info(nx, ny));
                        arrayList.add(new Info(nx, ny));
                    }
                }
            }
        }
        return population;
    }

    static int move(){
        int result=0;

        while (true) {
            boolean isMove = false;
            check = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!check[i][j]) {
                        int population = bfs(i, j);
                        if (arrayList.size() > 1) {
                            changePopulation(population);
                            isMove = true;
                        }
                    }
                }
            }
            if(!isMove) return result;
            result++;
        }
    }

    static void changePopulation(int population) {
        int avg = population / arrayList.size();
        for (Info info : arrayList) {
            A[info.x][info.y] = avg;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        check = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }
}
