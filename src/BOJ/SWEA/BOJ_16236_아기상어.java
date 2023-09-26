package BOJ.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 우선순위를 고려한 BFS
 */
public class BOJ_16236_아기상어 {

    static int N;
    static int[][] area;
    static int[] dx = {0, 0, 1, -1,}; // 0123 남북동서
    static int[] dy = {1, -1, 0, 0};
    static int sharkSize=2;
    static int time;

    static int cnt;



    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y){
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(x, y));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            int nowCnt=0;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N){
                    if (area[nx][ny] != 0) nowCnt++;
                }
            }

            if (nowCnt > 1) {

            }
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        area = new int[N][N];

        int sharkX=0, sharkY=0;

        time=0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());

                if (area[i][j] != 0) cnt++; // 물고기 수
                if (area[i][j] == 9) { // 아기 상어 위치
                    sharkX = i;
                    sharkY = j;
                    area[i][j]=0;
                }
            }
        }

        bfs(sharkX, sharkY);

        bw.write(time);
        bw.flush();
        bw.close();
    }
}
