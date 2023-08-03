package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 방문순서 출력 !!
 */
public class BOJ_24479_알고리즘수업_깊이우선탐색1 {

    static int N, M, R;
    static int u, v, cnt;
    static boolean[] visit;
    static ArrayList<Integer>[] arrayList;
    static int[] answer;

    static void dfs(int now) {

        answer[now] = ++cnt;
        visit[now] = true;

        for (Integer itg : arrayList[now]) {
            if (!visit[itg]) {
                dfs(itg);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        visit = new boolean[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            arrayList[u].add(v);
            arrayList[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arrayList[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
}
