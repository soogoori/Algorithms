package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
    static int N, D;
    static Info[] arr;
    static int[] dist;

    // 자기 자신과 매개변수 객체를 비교
    static class Info implements Comparable<Info>{
        int start, end, length;

        public Info(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Info o) {
            if(this.start < o.start) {
                return -1;
            }
            return 1;
        }
    }

    static int dijkstra(){
        int idx=0, move=0;
        dist[0]=0;

        while (move < D) {
            if (idx < arr.length) {
                Info now = arr[idx];
                if (move == now.start) {
                    dist[now.end] =Math.min(dist[move]+now.length, dist[now.end]);
                    idx++;
                }else{
                    dist[move+1]= Math.min(dist[move+1],dist[move]+1);
                    move++;
                }
            }else{
                dist[move+1]= Math.min(dist[move+1],dist[move]+1);
                move++;
            }
        }

        return dist[D];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new Info[N];
        dist = new int[10001];
        Arrays.fill(dist, 10001);

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            arr[i] = new Info(s, e, l);
        }
        Arrays.sort(arr);

        System.out.println(dijkstra());

    }
}
