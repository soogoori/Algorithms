package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 미해결
 */
public class BOJ_1449_수리공항승 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] leak = new int[N];

        int cnt=0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            leak[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leak);



        System.out.println(cnt);
    }

}
