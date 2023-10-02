package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10974_모든순열 {

    static boolean[] visit;
    static int[] result, num;
    static int N;
    static void findNum(int cnt){

        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[cnt] = num[i];
                findNum(cnt+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }

        result = new int[N];

        findNum(0);
    }
}
