package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 완전탐색 + 백트래킹.. DFS => 일일이 가능한 순열 모두 만들어서 확인
 */
public class BOJ_10819_차이를최대로_다른풀이 {

    static int[] arr;
    static int[] ans;
    static int N, result;
    static boolean[] visited;

    static void dfs(int cnt) {
        if(cnt==N){
            int sum=0;
            for (int i = 0; i < N-1; i++) {
                sum += Math.abs(arr[i] - arr[i + 1]);
            }
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                ans[cnt] = arr[i];
                visited[i]=true;
                dfs(cnt + 1);
                visited[i]=false;
            }
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(result);
    }
}
