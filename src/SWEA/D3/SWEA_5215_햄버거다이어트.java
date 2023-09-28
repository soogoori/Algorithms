package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * DFS + 부분조합
 */
public class SWEA_5215_햄버거다이어트 {

    static int L,N;
    static int max = Integer.MIN_VALUE;
    static int[][] hamburger;
    static void dfs(int start, int calSum, int scoreSum) {

        if (calSum > L) {
            return;
        }
        if (calSum <= L) {
            max = Math.max(max, scoreSum);
            System.out.println("max = " + max);
        }
        if (start == N) return;

        dfs(start+1, calSum+hamburger[start][1], scoreSum+hamburger[start][0]);
        dfs(start + 1, calSum, scoreSum);

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            hamburger = new int[N][2];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                hamburger[j][0] = Integer.parseInt(st.nextToken()); // 점수
                hamburger[j][1] = Integer.parseInt(st.nextToken()); // 칼로리
            }

            dfs(0, 0,0);

            bw.write("#" + i + " " + max + "\n");
        }
        bw.flush();
        bw.close();
    }
}
