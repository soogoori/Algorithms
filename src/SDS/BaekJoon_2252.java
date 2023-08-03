package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 인접리스트 + 위상정렬
public class BaekJoon_2252 {
    static int n, m;
    static int[] inDegree; // 진입차수
    static ArrayList<Integer>[] group; // 인접리스트
    static ArrayDeque<Integer> dq;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inDegree = new int[n + 1];
        group = new ArrayList[n+1];
        dq = new ArrayDeque<>();

        for(int i=1; i<=n; i++){
            group[i] = new ArrayList<Integer>();
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            inDegree[b]++;// 진입차수 증가
            group[a].add(b);
        }

        for(int i=1; i<=n; i++){
            if(inDegree[i]==0){
                dq.add(i);
            }
        }

        while (!dq.isEmpty()) {
            System.out.print(dq.peek());
            System.out.print(" ");
            int current = dq.poll();

            for(int i=0; i<group[current].size(); i++){
                int next = group[current].get(i);
                inDegree[next]--;
                if(inDegree[next]==0)
                    dq.addFirst(next);
            }
        }
    }
}
