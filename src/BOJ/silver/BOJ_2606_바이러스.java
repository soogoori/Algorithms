package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * silver3
 * 부모가 1인 노드 수
 */
public class BOJ_2606_바이러스 {

    static int N;
    static int[] parent;

    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        parent[bRoot] = aRoot;
    }

    public static int find(int a){
        if(parent[a] == a){
            return a;
        }else{
            return parent[a]=find(parent[a]);
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        int cnt=0;

        parent = new int[N+1];

        // 처음 초기화 -> 본인이 본인을 가르키기
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=1; i<=pair; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for(int i=1; i<=N; i++){
            if(find(i)==find(1)){
                cnt++;
            }
        }

        System.out.println(cnt-1);
    }
}
