package BOJ.Graph.UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {

    static int N, M; // N=사람 수, M=파티 수
    static int knowPeople; // knowPeople=진실을 아는 사람 수,
    static boolean[] knowNum; // knowNum=진실을 아는 사람의 번호
    static int[] parent;
    static ArrayList<Integer>[] party;

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            }else parent[x] = y;
        }
    }
    static int find(int x){
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        party = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 부모 = 자기자신으로 초기화
        }

        st = new StringTokenizer(br.readLine());
        knowPeople = Integer.parseInt(st.nextToken());
        knowNum = new boolean[51];

        for (int i = 0; i < knowPeople; i++) {
            knowNum[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int pre = Integer.parseInt(st.nextToken());
            party[i].add(pre);

            for (int j = 1; j < n; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
                union(pre, party[i].get(j));
                pre = party[i].get(j);
            }
        }

        for (int i = 1; i < knowNum.length; i++) {
            if (knowNum[i]) {
                knowNum[find(i)] = true;
            }
        }

        int parent;
        int total=0;
        for (int i = 0; i < M; i++) {
            if (party[i].size() > 0) {
                parent = find(party[i].get(0));
                if (!knowNum[parent]) total++;
            }
        }
        System.out.println(total);
    }
}
