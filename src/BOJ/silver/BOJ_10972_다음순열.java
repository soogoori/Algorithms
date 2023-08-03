package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미해결 -> 해결완 -> 완전탐색.
 */
public class BOJ_10972_다음순열 {
    static int N;
    static int[] num;

    static boolean next_permutation(){

        int i = N-1;

        while (i > 0 && num[i] <= num[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }

        int j = N-1;

        while (num[j] < num[i - 1]) {
            j--;
        }

        int temp = num[j];
        num[j] = num[i - 1];
        num[i-1] = temp;

        j=N-1;
        while (i < j) {
            temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            i++;
            j--;
        }

        return true;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        if (next_permutation()) {
            for (int i : num) {
                System.out.print(i+ " ");
            }
        }else{
            System.out.println(-1);
        }
    }
}
