package BOJ.Lv.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2720_세탁소사장동혁 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int Q = 25;
        int D = 10;
        int N = 5;
        int P = 1;

        int q=0,d=0,n=0,p=0;

        int[] change = new int[T];

        for (int i = 0; i < T; i++) {
            change[i] = Integer.parseInt(br.readLine());
        }

        for (int i : change) {
            q = i/Q;
            d = i%Q/D;
            n = i%Q%D/N;
            p = i%Q%D%N/P;
            System.out.println(q + " " + d + " " + n + " " + p);
        }
    }
}
