package BOJ.Lv.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4796_캠핑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int i=0;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == P && L == V && P == V && L == 0) {
                break;
            }

            int max=0;
            max+=V/P*L;

            if (V % P >= L) {
                max += L;
            } else {
                max += V % P;
            }
            i++;

            System.out.println("Case " + i + ": " + max);
        }
    }
}
