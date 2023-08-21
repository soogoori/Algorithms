package BOJ.Lv.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            A[i]-=B;
        }
        long supervisor=N;

        for (int i = 0; i < N; i++) {
            if (A[i] <=0)   continue;

            supervisor += A[i] / C;
            if (A[i] % C > 0) {
                supervisor++;
            }
        }

        System.out.println("supervisorCnt = " + supervisor);
    }
}
