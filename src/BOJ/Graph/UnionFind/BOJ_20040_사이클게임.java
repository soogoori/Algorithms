package BOJ.Graph.UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_20040_사이클게임 {

    static int[] parent;
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if(x<y) parent[y] =x;
            else parent[x] =y;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 사이클이 되기 위한 조건 ->
            if (find(a) != find(b)) {
                union(a, b);
            } else {
                System.out.println(i);
                return;
            }
        }
        bw.write("0");
        bw.flush();
        bw.close();
        br.close();
    }
}
