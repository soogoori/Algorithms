package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {

    static int n, s, cnt;
    static int[] arr;

    static void dfs(int idx, int sum){
        if (idx == n) {
            if (sum == s) {
                cnt++;
            }
            return;
        }

        System.out.println("sum+arr[idx] = " + (sum+arr[idx]));
        dfs(idx + 1, sum + arr[idx]); // 원소를 선택했을 때

        System.out.println("idx = " + idx);
        System.out.println("sum = " + sum);
        dfs(idx + 1, sum);  // 원소를 선택하지 않았을 때 
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (s == 0) cnt--;
        bw.write(cnt + " ");
        bw.flush();
        bw.close();
    }
}
