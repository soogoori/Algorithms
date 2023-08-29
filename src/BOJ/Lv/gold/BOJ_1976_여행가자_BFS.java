package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BFS -> N의 크기가 작아서 가능. N의 크기가 크다면 불가능
 */
public class BOJ_1976_여행가자_BFS {

    static int N, M;
    static int[] plan;
    static List<Info>[] list;

    static class Info{
        int end;

        public Info(int end) {
            this.end = end;
        }
    }
    public static boolean dijkstra(int start, int end){

        if (start == end) {
            return true;
        }
        boolean[] visit = new boolean[N + 1];
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(start));

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            if (!visit[info.end]) {
                visit[info.end] = true;
                for (Info next : list[info.end]) {
                    queue.add(next);
                    if (next.end == end) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        plan = new int[M];

        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                if (s[j].charAt(0) == '1') {
                    list[i].add(new Info(j+1));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M-1; i++) {
            if (!dijkstra(plan[i], plan[i + 1])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
