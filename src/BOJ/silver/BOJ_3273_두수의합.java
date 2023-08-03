package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두수의합 {
    static int[] arr;
    static int n, x;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int s=0;
        int l=n-1;
        int result=0;


        while (s < l) {
            long target = arr[s] + arr[l];
            if (target < x) {
                s++;
            } else if (target > x) {
                l--;
            } else {
                s++;
                l--;
                result++;
            }
        }

        System.out.println(result);
    }
}
