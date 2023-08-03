package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon_11657_타임머신 {

    static int N, M;
    static Info [] list;
    static long [] cost;
    static final int INF = Integer.MAX_VALUE;

    static class Info{
        int from, to, time;

        public Info(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }


    static void findShortestPath(int start){

    }

    static boolean findCylcle(){
        for(int j=1; j<=M; j++){
        }
        return true;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new Info[M + 1];
        cost = new long[N + 1];
        for(int i=1; i<=N; i++){
            cost[i] = INF;
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[i] = new Info(a, b, c);
        }

        findShortestPath(1);
        boolean isNegativeCycle = findCylcle();

        if(isNegativeCycle){
            bw.write("-1" + "\n");
            bw.flush();
            bw.close();
            return;
        }



    }
}
