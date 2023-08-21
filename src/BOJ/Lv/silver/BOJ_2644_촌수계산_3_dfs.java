package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BFS, DFS 풀이
 */
public class BOJ_2644_촌수계산_3_dfs {

    static boolean[][] chonsu;
    static boolean[] visited;
    static int n;
    static int a, b;
    static int depth;

    static void dfs(int p, int dist){
        visited[p]=true;

        if(p==b){
            depth = dist;
            return;
        }

        for(int i=1; i<=n; i++){
            if(chonsu[p][i] && !visited[i]){
                dfs(i, dist + 1);
            }
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        chonsu = new boolean[n+1][n+1];
        visited = new boolean[n + 1];

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            chonsu[x][y]=chonsu[y][x] = true;
        }

        dfs(a, 0);
        System.out.println(depth);
    }
}
