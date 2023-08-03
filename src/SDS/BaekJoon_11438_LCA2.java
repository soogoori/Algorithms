package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 11438_LCA 2
 * sparse table 최소 공통조상 빠르게 구하기
 * N의 크기 = 10만
 * M의 크기 = 10만  => 2^17=약 13만 => sparseTable 사용
 */

public class BaekJoon_11438_LCA2 {

    static int n,m;
    static int logN = 17; // K => 2의 몇 제곱까지 계산할지 저장한 변수 => 17로 선언해도 무방
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static boolean[] visited;
    static int[][] parent; // sparse table


    static void bfs(int start) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        depth[start] = 1;
        dq.add(start);

        while (!dq.isEmpty()) {
            int now = dq.poll();
            for (int next : tree[now]) {
                if (depth[next] == 0) {
                    depth[next] = depth[now]+1;
                    parent[0][next] = now;
                    dq.add(next);
                }
            }
        }
    }

    static void getSparseTable(){
        for(int i=1; i<=logN; i++){
            for(int j=1; j<=n; j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
    }


    static int getLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            return getLCA(b,a);
        }

        // 높이 맞추기
        for(int i=0; i<=logN; i++){
            if(((depth[a]-depth[b]) & (1<<i)) >=1){ // 비트 AND 연산 => 둘다 1일 경우 1로 반환
                a = parent[i][a];
            }
        }

        // 높이 맞추기 -> 다른 방법
        /*for(int i=0; i<=logN; i++){
            if(Math.pow(2,i)>=(depth[a]-depth[b])){
                a = parent[i][a];
            }
        }*/

        // 높이 맞췄으면 같은지 검사
        if(a==b){
            return a;
        }

        // 공통조상이 아닐 때까지 부모를 따라 올라감
        // 최종적으로는 LCA 바로 밑칸까지만 올라감.
        for(int i=logN; i>=0; i--){
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        tree = new ArrayList[n+1];
        visited = new boolean[n + 1];
        depth = new int[n + 1];
        parent = new int[logN + 1][n+1]; // 시간복잡도상 첫번째 배열에 적은 수 넣는 것이 더 효율적

        for(int i=0; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine());

        for(int i=1; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);

        }

        bfs(1);
        getSparseTable();

        m= Integer.parseInt(br.readLine());

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(getLCA(a, b) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
