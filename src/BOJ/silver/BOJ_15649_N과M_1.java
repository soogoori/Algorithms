package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * dfs (백트래킹)
 */
public class BOJ_15649_N과M_1 {

    static int N, M;
    static int[] num;
    static boolean[] visit;
    static int[] result;

    static void printNum(int start, int cnt){

        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                result[cnt] = num[i];
                visit[i] = true;
                printNum(start, cnt+1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        result = new int[M];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            num[i] = i+1;
        }

        printNum(0, 0);

    }
}
