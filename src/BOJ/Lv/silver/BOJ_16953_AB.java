package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DFS, bfs, greedy 다 가능
 */
public class BOJ_16953_AB {

    static long A, B;
    static int cnt;
    static int result;

    static int bfs() {
        Queue<Long> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long now = queue.poll();

                //if(now>B)   continue;

                if (now == B) {
                    return cnt+1;
                }
                if (now * 2 <= B) queue.add(now*2);
                if (now * 10 + 1 <= B) queue.add(now*10+1);
            }
            cnt++;
        }
        return -1;
    }

    static void dfs(int a, int cnt) {

        if (a == B) {
            result = cnt;
            return;
        }

        int n1, n2;

        if (a < B) {
            String n = String.valueOf(a)+"1";
            n1 = Integer.parseInt(n);
            n2 = a*2;

            dfs(n1, cnt + 1);
            dfs(n2, cnt + 1);
        }

        if(a>B) return;

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        //dfs(A, 1);
        System.out.println(bfs());
    }
}
