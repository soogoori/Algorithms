package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
    static int N, M;
    static long[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new long[N];

        long s=0;
        long e=0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            if (e < tree[i]) {
                e = tree[i];
            }
        }

        while (s <= e) {
            long mid = (s+e)/2;
            long sum=0;
            for (long target : tree) {
                if (mid <= target) {
                    sum += (target - mid);
                }
            }

            if (sum < M) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        System.out.println(s-1);
    }
}
