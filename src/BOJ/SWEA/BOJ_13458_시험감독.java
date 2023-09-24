package BOJ.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] Ai = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Ai[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long answer=0;
        answer+=N;

        for (int i = 0; i < N; i++) {
            if (Ai[i] - B <= 0) continue;
            answer += (Ai[i] - B) / C;
            if ((Ai[i] - B) % C > 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
