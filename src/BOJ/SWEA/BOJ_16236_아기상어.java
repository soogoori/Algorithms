package BOJ.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS + 구현 ..
 */
public class BOJ_16236_아기상어 {

    static int N, time, eatCnt, sharkX, sharkY;
    static int[][] area;
    static int[] dx = {0, 0, 1, -1,}; // 0123 남북동서
    static int[] dy = {1, -1, 0, 0};
    static int sharkSize=2;

    static class Info{
        int x, y, time;

        public Info(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static boolean bfs(){
        time=0;

        if (eatCnt == sharkSize) {
            eatCnt=0;
            sharkSize++;
        }

        boolean[][] visit = new boolean[N][N];

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int minTime = Integer.MAX_VALUE;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(sharkX, sharkY, 0));
        visit[sharkX][sharkY] = true;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            //최소 시간으로 물고기를 먹을 수 있는 시간을 넘으면 종료
           if(now.time >= minTime)
                break;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 아기 상어가 물고기를 지나갈 수 있는 칸에 들어왔을 때
                if(nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny] && area[nx][ny]<=sharkSize){
                    if (area[nx][ny] > 0 && sharkSize > area[nx][ny]) { // 먹을 수 있는 물고기라면 위, 왼쪽 좌표 고려. 먹을 수 없는 물고기라면 그냥 지나감
                        if (nx < minX) { // 가장 위에 있는 물고기
                            minX = nx;
                            minY = ny;
                            minTime = now.time+1;
                        } else if (nx == minX) { // 가장 위에 있는 물고기가 여러 마리일 때는 가장 왼쪽에 있는 물고기
                            if (ny < minY) {
                                minY = ny;
                                minTime = now.time+1;
                            }
                        }
                    }
                    // 좌표 정보를 큐에 저장
                    queue.add(new Info(nx, ny, now.time + 1));
                    visit[nx][ny]=true;
                }
            }
        }

        if (minTime == Integer.MAX_VALUE) {
            return false;
        } else {
            sharkX = minX;
            sharkY = minY;
            eatCnt++;
            time = minTime;
            area[sharkX][sharkY] = 0; // 물고기 먹음

            return true;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        area = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());

                if (area[i][j] == 9) { // 아기 상어 위치
                    sharkX = i;
                    sharkY = j;
                    area[i][j]=0;
                }
            }
        }

        int timeSum=0;

        while(bfs()){
            timeSum+=time;
        }

        bw.write(timeSum + " ");
        bw.flush();
        bw.close();
    }
}
