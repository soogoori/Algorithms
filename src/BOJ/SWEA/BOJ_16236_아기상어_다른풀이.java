package BOJ.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS + 구현 ..
 */
public class BOJ_16236_아기상어_다른풀이 {

    static int N, ans, eatCnt;
    static int[][] area;
    static int[] dx = {0, 0, 1, -1,}; // 0123 남북동서
    static int[] dy = {1, -1, 0, 0};
    static int sharkSize=2;

    static class Info{
        int x, y, dist;

        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Queue<Info> queue = new LinkedList<>();

        N = Integer.parseInt(br.readLine());

        area = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] == 9) { // 아기 상어 위치
                    queue.add(new Info(i, j, 0));
                    area[i][j]=0;
                }
            }
        }

        while (true) {
            ArrayList<Info> eatFish = new ArrayList<>();
            int[][] dist = new int[N][N];

            while (!queue.isEmpty()) {
                Info now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (dist[nx][ny] == 0 && area[nx][ny] <= sharkSize) {
                            dist[nx][ny] = dist[now.x][now.y] +1;
                            queue.add(new Info(nx, ny, dist[nx][ny]));
                            if (area[nx][ny] != 0 && area[nx][ny] < sharkSize) {
                                eatFish.add(new Info(nx, ny, dist[nx][ny])); // 먹을 수 있는 물고기 저장
                            }
                        }
                    }
                }
            }

            // 먹을 수 있는 물고기가 없다면 결과(이동한 거리) 출력
            if (eatFish.size() == 0) {
                System.out.println(ans);
                return;
            }

            Info nowFish = eatFish.get(0);

            for (int i = 0; i < eatFish.size(); i++) {
                // 거리가 제일 작은 물고기
                if (nowFish.dist > eatFish.get(i).dist) {
                    nowFish = eatFish.get(i);
                } // 거리가 같다면
                else if (nowFish.dist == eatFish.get(i).dist) {
                    // 가장 위에 있는 물고기
                    if (nowFish.x > eatFish.get(i).x) {
                        nowFish = eatFish.get(i);
                    }// 물고기가 모두 위에 있다면
                    else if (nowFish.x == eatFish.get(i).x) {
                        // 가장 왼쪽에 있는 물고기
                        if (nowFish.y > eatFish.get(i).y) {
                            nowFish = eatFish.get(i);
                        }
                    }
                }
            }

            // 선택한 물고기 먹기
            area[nowFish.x][nowFish.y] = 0;
            ans +=nowFish.dist;
            eatCnt++;

            if (sharkSize == eatCnt) {
                sharkSize++;
                eatCnt=0;
            }
            queue.add(nowFish); // 물고기를 먹은 좌표 저장 후 다시 탐색
        }
    }
}
