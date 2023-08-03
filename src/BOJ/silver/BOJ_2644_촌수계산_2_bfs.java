package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BFS, DFS 풀이
 */
public class BOJ_2644_촌수계산_2_bfs {

    static ArrayList<Integer>[] chonsu;
    static int n;
    static int[] depth;
    static int a, b;

    static void bfs(){
        ArrayDeque<Integer> adq= new ArrayDeque<>();
        adq.add(a);
        while (!adq.isEmpty()) {
            int now = adq.poll();
            if(now==b){
                return;
            }
            for (Integer n : chonsu[now]) {
                if(depth[n]==0){
                    depth[n]=depth[now]++;
                    adq.add(n);
                }
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

        chonsu = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            chonsu[i] = new ArrayList<>();
        }
        depth = new int[n + 1];


        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            chonsu[x].add(y);
            chonsu[y].add(x);
        }

        bfs();
        if(depth[b-1]>0){
            System.out.println(depth[b-1]);
        }else{
            System.out.println(-1);
        }
    }
}
