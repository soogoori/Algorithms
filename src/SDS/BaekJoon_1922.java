package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BaekJoon_1922 {
    static int n,m;
    static int[][] edge; // 간선리스트
    static int[] root; // 루트노드

    static void init(){
        for(int i=0; i<=n; i++){
            root[i] = i;
        }
    }
    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        root[bRoot] = aRoot;
    }

    static int find(int a){
        if(root[a]==a){
            return a;
        }else{
            return root[a] = find(root[a]);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        edge = new int[m+1][3];
        root = new int[n+1];
        init();

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            edge[i][0] = a;
            int b =Integer.parseInt(st.nextToken());
            edge[i][1] = b;
            int c= Integer.parseInt(st.nextToken());
            edge[i][2] = c; // 비용
        }

        Arrays.sort(edge, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        int cost=0;

        int connectCnt = 0; // 간선을 n-1개 연결하면 최소신장트리 완성
        for (int i=1; i<edge.length; i++) {
            if(find(edge[i][0])!=find(edge[i][1])){
                union(edge[i][0], edge[i][1]);
                cost+=edge[i][2];
                connectCnt++;
            }

            if(connectCnt==n-1){
                break;
            }
        }
        System.out.println(cost);
    }
}
