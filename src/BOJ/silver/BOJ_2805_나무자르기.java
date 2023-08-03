package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {

    static int N, M;
    static int min, max;
    static int[] tree;

    static int bSearch(){

        int cmp;

        while (min < max) {
            long sum=0;
            cmp = (min+max)/2;

            for (int i = 0; i < N; i++) {
                if (cmp < tree[i]) {
                    sum += tree[i]- cmp;
                }
            }

            if (sum < M) { // 더 많이 잘라야 함. -> 높이 낮춰야 함.
                max = cmp;
            } else{
                min = cmp+1;
            }
        }

        return min-1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min=0;
        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        System.out.println(bSearch());
    }
}
