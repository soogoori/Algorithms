package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미해결.. -> 백준에서 제출하면 인덱스 초과 오류 발생...
 */
public class BOJ_14499_주사위굴리기 {

    static int[][] dice = {{-1, 0, -1},
                            {0, 0, 0},
                            {-1, 0, -1},
                            {-1, 0, -1}};

    static void East(){
        int tmp1 = dice[1][0];
        int tmp2 = dice[1][1];
        int tmp3 = dice[1][2];
        int tmp4 = dice[3][1];

        dice[1][1] = tmp1;
        dice[1][2] = tmp2;
        dice[3][1] = tmp3;
        dice[1][0] = tmp4;
    }

    static void West(){
        int tmp1 = dice[1][0];
        int tmp2 = dice[1][1];
        int tmp3 = dice[1][2];
        int tmp4 = dice[3][1];

        dice[1][1] = tmp3;
        dice[1][2] = tmp4;
        dice[3][1] = tmp1;
        dice[1][0] = tmp2;
    }

    static void North(){
        int tmp1 = dice[0][1];
        int tmp2 = dice[1][1];
        int tmp3 = dice[2][1];
        int tmp4 = dice[3][1];

        dice[0][1] = tmp2;
        dice[1][1] = tmp3;
        dice[2][1] = tmp4;
        dice[3][1] = tmp1;
    }

    static void South(){
        int tmp1 = dice[0][1];
        int tmp2 = dice[1][1];
        int tmp3 = dice[2][1];
        int tmp4 = dice[3][1];

        dice[0][1] = tmp4;
        dice[1][1] = tmp1;
        dice[2][1] = tmp2;
        dice[3][1] = tmp3;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] order = new int[K];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            if (x >= 0 && y >= 0 && y < N && x < M) {
                switch (order[i]) {
                    case 1:
                        //동쪽
                        if (x+1<M) {
                            if (map[y][x+1] == 0) {
                                East();
                                map[y][++x] = dice[3][1];
                            }else{
                                East();
                                dice[3][1] = map[y][x+1];
                                map[y][++x] = 0;
                            }
                            System.out.println("dice = " + dice[1][1]);
                        }
                        break;

                    case 2:
                        // 서쪽
                        if (x-1>=0) {
                            if (map[y][x-1] == 0) {
                                West();
                                map[y][--x] = dice[3][1];
                            }else{
                                West();
                                dice[3][1] = map[y][x-1];
                                map[y][--x] = 0;
                            }
                            System.out.println("dice = " + dice[1][1]);
                        }

                        break;
                    case 3:
                        // 북쪽
                        if (y -1>=0) {
                            if (map[y-1][x] == 0) {
                                North();
                                map[--y][x] = dice[3][1];
                            }else{
                                North();
                                dice[3][1] = map[y-1][x];
                                map[--y][x] = 0;
                            }
                            System.out.println("dice = " + dice[1][1]);
                        }
                        break;
                    case 4:
                        // 남쪽
                        if (y + 1 < N) {
                            if (map[y+1][x] == 0) {
                                South();
                                map[++y][x] = dice[3][1];
                            }else{
                                South();
                                dice[3][1] = map[y+1][x];
                                map[++y][x] = 0;
                            }
                            System.out.println("dice = " + dice[1][1]);
                        }
                        break;
                }
            }
        }
    }
}
