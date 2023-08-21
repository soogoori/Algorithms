package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기_재풀이 {

    static int N;
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visit;


    static void findParent(int start){

        visit[start] = true;

        for (int n : tree[start]) {
            /*if (n==1) {
                parent[start] = n;
                visit[n] = false;
                return;
            }
            findParent(n);
            parent[start] = n;
            return;*/
            System.out.println("n = " + n);

            if (!visit[n]) {
                parent[n]=start;
                findParent(n);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        parent = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            tree[n1].add(n2);
            tree[n2].add(n1);
        }

        findParent(1);

        for (int i = 2; i <= N; i++) {
            System.out.println("parent = " + parent[i]);
        }
    }
}
