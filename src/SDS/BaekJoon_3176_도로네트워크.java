package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 트리 그래프 (정점 n개, 간선 n-1개) -> 최단 경로 찾기
 * LCA 알고리즘을 통해 두 노드의 공통 조상 노드를 찾고
 * 각각의 노드에서 공통 조상 노드까지 최단 도로, 최장 도로 구함
 */
public class BaekJoon_3176_도로네트워크 {

    static int n;
    static int logN;
    static int min, max;
    static int[] depth;
    static int[][] parent;
    static int [][] minDistance;
    static int [][] maxDistance;
    static ArrayList<Info>[] tree;

    static class Info{
        int node;
        int distance;

        public Info(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static void getLogN(){
        logN=0;
        for(int i=1; i<n; i*=2){
            logN++;
        }
    }

    static void makeSparseTable(){
        for(int i=1; i<=logN; i++){
            for(int j=1; j<=n; j++){
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
                minDistance[i][j] = Math.min(minDistance[i - 1][j], minDistance[i - 1][parent[i - 1][j]]);
                maxDistance[i][j] = Math.max(maxDistance[i - 1][j], maxDistance[i - 1][parent[i - 1][j]]);
            }
        }
    }


    static void bfs(int start){
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        depth[start] = 1;
        dq.add(start);

        while (!dq.isEmpty()) {
            int now = dq.poll();
            for (Info next : tree[now]) {
                if (depth[next.node] == 0) {
                    depth[next.node] = depth[now] + 1;
                    parent[0][next.node] = now;
                    minDistance[0][next.node] = next.distance;
                    maxDistance[0][next.node] = next.distance;
                    dq.add(next.node);
                }
            }
        }
    }

    static int getLCA(int a, int b){
        if (depth[a] < depth[b]) {
            return getLCA(b, a);
        }

        min = Integer.MAX_VALUE;
        max = -1;

        // 높이 맞추기
        for(int i=0; i<=logN; i++){
            if(((depth[a]-depth[b]) & (1<<i)) >=1){
                min = Math.min(min, minDistance[i][a]);
                max = Math.max(max, maxDistance[i][a]);
                a = parent[i][a];
            }
        }

        if (a == b) {
            return a;
        }

        for(int i = logN; i>=0; i--){
            if (parent[i][a] != parent[i][b]) {
                min = Math.min(min, Math.min(minDistance[i][a], minDistance[i][b]));
                max = Math.max(max, Math.max(maxDistance[i][a], maxDistance[i][b]));
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        // 여기 이해 안감...ㅠㅠㅠ
        min = Math.min(min, Math.min(minDistance[0][a], minDistance[0][b]));
        max = Math.min(max, Math.max(maxDistance[0][a], maxDistance[0][b]));
        
        return parent[0][a];
    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        depth = new int[n + 1];
        getLogN();

        parent = new int[logN+1][n+1];
        minDistance = new int[logN+1][n+1];
        maxDistance = new int[logN+1][n+1];

        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        int a, b, c;
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            tree[a].add(new Info(b, c));
            tree[b].add(new Info(a, c)); // 방향이 없으므로 양쪽으로 저장
        }

        bfs(1);
        makeSparseTable();

        int d,e;
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine(), " ");

            d =Integer.parseInt(st.nextToken());
            e =Integer.parseInt(st.nextToken());
            getLCA(d, e);
            bw.write(min + " " + max + "\n");
        }

        bw.flush();
        bw.close();

    }
}
