package BOJ.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 백트래킹 + DFS
 */
public class BOJ_15686_치킨배달 {

    static int N,M, ans;
    static int[][] city;
    static ArrayList<Info> house;
    static ArrayList<Info> chicken;
    static boolean[] visit;
    static int[][] dist;


    static class Info{
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static void dfs(int start, int cnt){

        if (cnt == M) {
            int res=0;

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visit[j]) {
                        int chickenDist = Math.abs(house.get(i).r-chicken.get(j).r) + Math.abs(house.get(i).c-chicken.get(j).c);
                        temp = Math.min(temp, chickenDist);
                    }
                }
                res +=temp;
            }
            ans = Math.min(ans, res);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            visit[i] = true;
            //System.out.println("dfs[i+1][cnt+1] " + (i+1) + " " + (cnt+1));
            dfs(i + 1, cnt + 1);
            visit[i] =false;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];
        dist = new int[N][N];

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1) {
                    house.add(new Info(i, j));
                } else if (city[i][j] == 2) {
                    chicken.add(new Info(i, j));
                }
            }
        }

        visit = new boolean[chicken.size()];
        ans = Integer.MAX_VALUE;

        dfs(0, 0);

        bw.write(ans + " ");
        bw.flush();
        bw.close();
    }
}
