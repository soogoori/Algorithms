package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최장 연속 부분 수열의 길이
 * 투 포인터 → start와 end 잘 설정하기
 */
public class BOJ_20922_겹치는건싫어 {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int[] cnt = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end=0;
        int len;
        int max =0;

        while (end < N) {
            while (end < N && cnt[arr[end]] <K) {
                cnt[arr[end]]++;
                end++;
            }
            len = end-start;
            max = Math.max(max, len);
            cnt[arr[start]]--;
            start++;
        }
        System.out.println(max);
    }
}
