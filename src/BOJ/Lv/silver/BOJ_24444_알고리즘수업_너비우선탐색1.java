package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24444_알고리즘수업_너비우선탐색1 {

    static int N, M, R;
    static int u, v;
    static ArrayList<Integer>[] arrayList;
    static int[] visit;
    static int cnt;

    static void bfs(int now) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);

        visit[now] = ++cnt;

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (Integer i : arrayList[n]) {
                if(visit[i]>0)  continue;
                visit[i] = ++cnt;
                queue.add(i);
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
        visit = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            arrayList[u].add(v);
            arrayList[v].add(u);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(arrayList[i]);
        }

        bfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visit[i]);
        }
    }
}
