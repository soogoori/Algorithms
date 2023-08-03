package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9372_상근이의여행 {
    static int N,M;
    static ArrayList<Integer>[] plane;
    static boolean[] visit;
    static int cnt;

    static void dfs(int start){

        visit[start] = true;

        for (int n : plane[start]) {

            if (!visit[n]) {
                int next = n;
                cnt++;
                dfs(n);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            plane = new ArrayList[N + 1];
            visit = new boolean[N + 1];
            cnt=0;

            for (int k = 0; k <= N; k++) {
                plane[k] = new ArrayList<>();
            }

            for (int j = 1; j <= M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                plane[a].add(b);
                plane[b].add(a);
            }

            dfs(1);

            System.out.println(cnt);
        }
    }
}
