package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 사이클 찾기 → DFS
 */
public class BOJ_2668_숫자고르기 {

    static int[] arr;
    static boolean[] visit;
    static int target;
    static ArrayList<Integer> answer;

    static void dfs(int i){

        if (!visit[arr[i]]) {
            visit[arr[i]] = true;
            dfs(arr[i]);
            visit[arr[i]] =false;
        }

        if (target == arr[i]) {
            answer.add(target);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();

        arr = new int[N+1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            target = i;
            dfs(i);
            visit[i] =false;
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }
}
