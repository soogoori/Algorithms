package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_N과M_3 {

    static int N, M;
    static boolean[] visit;
    static int[] num;
    static StringBuilder sb;

    static void printNum(int cnt){
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(num[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            num[cnt] = i+1;
            printNum(cnt+1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[M];
        visit= new boolean[N];
        printNum(0);
    }
}
