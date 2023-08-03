package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N과M_5 {

    static int N,M;
    static int[] arr;
    static int[] num;
    static boolean[] visit;

    static void sortNum(int start, int cnt){
        if(cnt == M){
            for (int i = 0; i < M; i++) {
                System.out.print(num[i]+ " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i <N; i++) {
            if (!visit[i]){
                num[cnt] =arr[i];
                visit[i] = true;
                sortNum(i+1,cnt+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];
        num = new int[M];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        sortNum(0, 0);

    }
}
