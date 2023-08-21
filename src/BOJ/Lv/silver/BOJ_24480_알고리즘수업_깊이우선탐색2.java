package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24480_알고리즘수업_깊이우선탐색2 {

    static int N, M, R;
    static int u, v;
    static ArrayList<Integer>[] arrList;
    static int[] visit;
    static int cnt;

    static void dfs(int now){

        if (visit[now] == 0) {
            visit[now] = ++cnt;
        }

        for (Integer i : arrList[now]) {
            if(visit[i]>0)  continue;
            visit[i] = ++cnt;
            dfs(i);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arrList = new ArrayList[N + 1];
        visit = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            arrList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            arrList[u].add(v);
            arrList[v].add(u);
        }

        // 내림차순으로 방문하기 때문에 내림차순으로 정렬
        for (int i = 0; i <= N; i++) {
            Collections.sort(arrList[i], Collections.reverseOrder());
        }

        for (ArrayList<Integer> integers : arrList) {
            System.out.println("integers = " + integers);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visit[i]);
        }
    }
}
