package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {

    static int n;
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visit;

    static void findParent(int n){
        visit[n]=true;
        for(int i=0; i<tree[n].size(); i++){
            int now = tree[n].get(i);

            if(!visit[now]){
                parent[now] = n;
                findParent(now);
            }
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        visit = new boolean[n+1];
        tree = new ArrayList[n + 1];

        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=1; i<=n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }
        findParent(1);

        for(int i=2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }

}
