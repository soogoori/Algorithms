package BOJ.Graph.UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Binary Search
 * BFS / DFS
 */
public class BOJ_1939_중량제한 {

    static int N, M;
    static int x,y; // 공장이 위치해 있는 섬의 번호
    static long total;
    static ArrayList<Info>[] arr;

    static class Info{
        int b, c;

        public Info(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }

    static boolean bfs(int weight){
        Queue<Info> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        queue.add(new Info(x, 0));

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            if (info.b == y) {
                return true;
            }

            for (Info next : arr[info.b]) {
                if (next.c >= weight && !visit[next.b]) {
                    queue.add(next);
                    visit[next.b] = true;
                }
            }
        }
        return false;
    }

    static void binarySearch(int l, int r) {

        while (l <= r) {
            int mid = (r+l)/2;

            if (bfs(mid)) {
                l = mid + 1;
                total = mid;
            } else {
                r = mid-1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a].add(new Info(b, c));
            arr[b].add(new Info(a, c));

            left = Math.min(left, c); // 최소 중량
            right = Math.max(right, c); // 최대 중량
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()); // 시작 도시
        y = Integer.parseInt(st.nextToken()); // 도착 도시

        binarySearch(left, right);

        bw.write(String.valueOf(total));
        bw.close();
        br.close();
    }
}
