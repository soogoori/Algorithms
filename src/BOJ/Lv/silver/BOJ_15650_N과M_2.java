package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과M_2 {

    static int N, M;
    static boolean[] visit;
    static int[] num;

    static void printNum(int start, int cnt){

        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(num[i]+ " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <N; i++) {
            if (!visit[i]) {
                visit[i]=true;
                num[cnt] = i+1;
                printNum(i+1, cnt+1);
                visit[i] = false;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        num = new int[M];

        printNum(0, 0);
    }
}
