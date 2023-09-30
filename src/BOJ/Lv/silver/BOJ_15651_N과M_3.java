package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15651_N과M_3 {
    static int N, M;
    static int[] result;
    static BufferedWriter bw;


    static void printNum(int cnt) throws Exception
    {
        if (cnt > M) {
            for (int i = 1; i <= M; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            result[cnt] = i;
            printNum(cnt+1);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M + 1];

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        printNum(1);

        bw.flush();
        bw.close();
    }
}
