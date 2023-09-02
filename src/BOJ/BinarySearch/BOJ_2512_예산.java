package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Binary Search 이분탐색
 */
public class BOJ_2512_예산 {

    static int N, M;
    static int[] budget;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        budget = new int[N];
        long sum=0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
        }

        M = Integer.parseInt(br.readLine());
        long answer=0;
        Arrays.sort(budget);

        if (sum <= M) {
            System.out.println(budget[N - 1]);
            return;
        } else {
            long s = 0;
            long e = budget[N - 1];

            while (s<=e) {
                long mid = (s+e)/2;
                sum = 0;
                for (int money : budget) {
                    if (mid <= money) {
                        sum += mid;
                    } else {
                        sum+=money;
                    }
                }
                if (sum > M) {
                    e = mid-1;
                } else {
                    s = mid+1;
                    answer = Math.max(answer, mid);
                }
            }
        }
        System.out.println(answer);
    }
}
