package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2531_회전초밥 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 회전초밥 벨트에 놓인 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] type = new int[d + 1];
        int[] belt = new int[N];

        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int cnt=0;
        for (int i = 0; i < k; i++) {
            if (type[belt[i]] == 0) {
                cnt++;
            }
            type[belt[i]]++;
        }

        int max = cnt;

        for (int i = 0; i < N; i++) {
            if (max <= cnt) {
                if (type[c] == 0) {
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }

            if (type[belt[i]] == 1) {
                cnt--;
            }
            type[belt[i]]--;

            if (type[belt[(i + k) % N]] == 0) {
                cnt++;
            }
            type[belt[(i + k) % N]]++;
        }

        System.out.println(max);
    }
}
