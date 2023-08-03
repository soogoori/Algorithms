package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652_N과M_4 {

    static int N, M;
    static int[] arr;
    static boolean[] visit;

    static void findNum(int start, int cnt){

        if(cnt==M){
            for (int i = 0; i < cnt; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            arr[cnt] = i+1;
            findNum(i, cnt+1);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        findNum(0, 0);
    }
}
