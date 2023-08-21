package BOJ.Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS
 */
public class BOJ_1697_숨바꼭질 {

    static int N, K;
    static int[] loc;
    static int[] method = {-1, 1, 2};
    public static void bfs(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        loc[s] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                System.out.println(loc[now] - 1);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next=0;

                if (i == 2) {
                    next = now * method[i];
                } else {
                    next = now + method[i];
                }

                if (next >= 0 && next < 100001 && loc[next]==0) {
                    queue.add(next);
                    loc[next] = loc[now]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        loc = new int[100001];

        bfs(N);
    }
}
