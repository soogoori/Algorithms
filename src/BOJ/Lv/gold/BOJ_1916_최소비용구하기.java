package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {

    static int N, M;
    static int start, arrive;
    static ArrayList<Info>[] bus;
    static int[] minCost;
    static boolean[] visit;
    static int INF = Integer.MAX_VALUE;

    static class Info implements Comparable<Info> {
        int end, cost;

        public Info(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.cost, o.cost);
        }
    }


    // 우선순위 큐를 사용하기 때문에 visit은 딱히 필요 없을듯.
    static void findLeastCost(int s){
        PriorityQueue<Info> adq = new PriorityQueue<>();
        adq.add(new Info(s, 0));
        minCost[s]=0;

        while (!adq.isEmpty()) {
            Info now = adq.poll();
            System.out.println("now.end = " + now.end);
            if(!visit[now.end]){
                visit[now.end]=true;

                for(int i=0; i<bus[now.end].size(); i++){
                    Info next = bus[now.end].get(i);
                    System.out.println("next.end = " + next.end);
                    
                    if(!visit[next.end] && minCost[next.end]>minCost[now.end]+next.cost){
                        minCost[next.end] = minCost[now.end]+next.cost;
                        adq.add(new Info(next.end, minCost[next.end]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        bus = new ArrayList[M + 1];
        minCost = new int[M + 1];
        visit = new boolean[N + 1];

        Arrays.fill(minCost, INF);

        for(int i=1; i<=M; i++){
            bus[i] = new ArrayList<Info>();
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bus[s].add(new Info(e, c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        arrive = Integer.parseInt(st.nextToken());

        findLeastCost(start);

        System.out.println(minCost[arrive]);
    }

}
