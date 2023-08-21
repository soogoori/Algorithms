package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미해결
 */
public class BOJ_20055_컨베이어벨트위의로봇 {

    static int N, K;
    static int[] Ai;
    static int[] belt;
    static int cnt; // 내구도가 0인 칸의 개수

    static void moveBelt(){ // 1
        for (int i = 0; i < 2 * N; i++) {
            if (belt[i] - 1 == 0) {
                belt[i] = 2*N;
            }else   belt[i] = belt[i] - 1;
        }
        /*for (int i : belt) {
            System.out.println("i = " + i);
        }*/
    }

    static void moveRobot(){

    }

    static void check(){

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Ai = new int[2 * N];
        belt = new int[2 * N];

        for (int i = 0; i < 2 * N; i++) {
            belt[i]=i+1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            Ai[i] = Integer.parseInt(st.nextToken());
        }

        moveBelt();

    }
}
