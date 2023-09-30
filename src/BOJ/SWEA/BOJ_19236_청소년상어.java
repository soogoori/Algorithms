package BOJ.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  DFS + 백트래킹
 */
public class BOJ_19236_청소년상어 {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer= Integer.MIN_VALUE;
    static class Info{

        // 물고기가 위치하는 행과 열 => r,c
        // 물고기 번호 => idx
        // 물고기 방향 => dir
        int r, c, idx, dir;

        // 물고기 생존여부
        boolean isAlive;

        public Info(int r, int c, int idx, int dir, boolean isAlive) {
            this.r = r;
            this.c = c;
            this.idx = idx;
            this.dir = dir;
            this.isAlive = isAlive;
        }
    }

    static void fishMove(int x, int y, Info fishInf, Info[] fish, int[][] area){ // x, y는 상어가 있는 칸

        for (int i = 0; i < 8; i++) {
            int nx = fishInf.r + dx[fishInf.dir];
            int ny = fishInf.c + dy[fishInf.dir];

            // 범위 안에 없거나 이동할 칸에 상어가 있다면 반시계방향으로 45도 회전
            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || (nx == x && ny == y)) {
                fishInf.dir = (fishInf.dir+1)%8;
                continue;
            }

            // 범위 안에 있고 이동할 칸에 상어가 없다면 물고기 이동시켜서 자리 바꾸기
            Info next = fish[area[nx][ny]]; // 이동할 칸
            area[fishInf.r][fishInf.c] = next.idx; // 현재 있는 칸을 이동할 칸과 바꾸기
            area[nx][ny] = fishInf.idx; // 이동할 칸을 현재 있는 칸과 바꾸기

            next.r = fishInf.r;
            next.c = fishInf.c;

            fishInf.r = nx;
            fishInf.c = ny;

            break; // 다음 번호 물고기 이동시켜야하므로 일단 반복문 빠져나옴
        }
    }


    static void dfs(int r, int c, int sharkDir, int eatFish, int[][] area, Info[] fish){
        eatFish+=area[r][c]; // 물고기 먹음
        sharkDir = fish[area[r][c]].dir; // 물고기 방향 가짐
        fish[area[r][c]].isAlive = false; // 물고기는 잡혀서 죽음

        answer = Math.max(answer, eatFish);

        // 물고기 이동
        for (int i = 1; i <= 16; i++) {
            if (fish[i].isAlive) {
                fishMove(r, c, fish[i], fish, area); // r, c는 상어가 있는 칸
            }
        }

        // 상어 이동
        for (int i = 1; i <= 3; i++) {
            int nr = r + dx[sharkDir]*i;
            int nc = c + dy[sharkDir]*i;

            // 범위 안에 있으며
            if (nr >= 0 && nc >= 0 && nr < 4 && nc < 4) {
                if (fish[area[nr][nc]].isAlive) { // 물고기가 존재한다면 (살아있다면)

                    // 일단 기존 정보 저장
                    Info[] tempInfo = new Info[17];
                    int[][] tempArea = new int[4][4];

                    for (int j = 1; j <= 16; j++) {
                        Info inf = fish[j];
                        tempInfo[j] = new Info(inf.r, inf.c, inf.idx, inf.dir, inf.isAlive);
                    }

                    for (int j = 0; j < 4; j++) {
                        tempArea[j] = area[j].clone();
                    }

                    dfs(nr, nc, sharkDir, eatFish, area, fish);

                    fish = tempInfo;
                    area = tempArea;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] area = new int[4][4];
        Info[] fish = new Info[17];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                fish[a] = new Info(i, j, a, b - 1, true); // 물고기 정보 저장 (물고기 위치, 방향, 생존여부)
                area[i][j] = a; // 해당하는 칸에 물고기 저장
            }
        }

        dfs(0, 0, 0 , 0, area, fish);

        System.out.println(answer);
    }
}
