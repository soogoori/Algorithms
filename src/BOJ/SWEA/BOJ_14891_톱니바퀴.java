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
 * 구현
 */
public class BOJ_14891_톱니바퀴 {

    static class Info{
        int num, dir;
        public Info(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }

    static int[][] sawTooth;
    static int[] rotateDir;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        sawTooth = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                sawTooth[i][j] = str.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());
            rotateDir = new int[4];

            rotateDir[n] = d;

            rightCheck(n);
            leftCheck(n);

            //dirCheck(n);
            for (int j = 0; j < 4; j++) {
                rotate(j);
            }

        }

        int total =0;
        for (int i = 0; i < 4; i++) {
            if (sawTooth[i][0] == 1) {
                total += Math.pow(2, i);
            }
        }
        bw.write(total + " ");
        bw.flush();
        bw.close();
    }

    static void dirCheck(int n) {
        // 우측 확인
        for (int i = n + 1; i < 4; i++) {
            if (sawTooth[i][6] != sawTooth[i - 1][2]) {
                rotateDir[i] = -rotateDir[i - 1];
            }else   break;
        }

        // 좌측 확인
        for (int i = n - 1; i >= 0; i--) {
            if (sawTooth[i][2] != sawTooth[i + 1][6]) {
                rotateDir[i] = -rotateDir[i + 1];
            }else   break;
        }
    }


    static void rightCheck(int n){

        if (n <=2) {
            // 극이 다르면 회전
            if (sawTooth[n][2] != sawTooth[n + 1][6]) {
                rotateDir[n+1] = -rotateDir[n];
                rightCheck(n + 1);
            }
        }
    }

    static void leftCheck(int n){
        if (n >= 1) {
            // 극이 다르면 회전
            if (sawTooth[n][6] != sawTooth[n - 1][2]) {
                rotateDir[n-1] = -rotateDir[n];
                leftCheck(n - 1);
            }
        }
    }

    static void rotate(int n){
        // -1 이라면 반시계방향 회전
        if (rotateDir[n] == -1) {
            int temp = sawTooth[n][0];
            for (int i = 0; i < 7; i++) {
                sawTooth[n][i] = sawTooth[n][i+1];
            }
            sawTooth[n][7]= temp;
        }
        else if(rotateDir[n]==1){ // 1이라면 시계방향 회전
            int temp = sawTooth[n][7];
            for (int i = 7; i >0; i--) {
                sawTooth[n][i] = sawTooth[n][i-1];
            }
            sawTooth[n][0] = temp;
        }
    }
}
