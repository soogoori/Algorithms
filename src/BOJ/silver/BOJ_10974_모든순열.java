package BOJ.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10974_모든순열 {

    static int[] arr;
    static boolean[] visited;
    static int N;

    static void next_Permutation(int cnt){

        if (cnt == N) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            arr[cnt] = i+1;
            visited[i] = true;
            next_Permutation(cnt + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];

        next_Permutation(0);
    }
}
