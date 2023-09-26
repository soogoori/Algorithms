package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 완전탐색 + dfs
 */
public class SWEA_1244_최대상금 {

    static String[] arr;
    static int max, chance;
    static void dfs(int start, int cnt){
        if (cnt == chance) {
            String result = "";
            for (String s : arr) {
                result += s;
            }
            max = Math.max(max, Integer.parseInt(result));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // 교환
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j]=temp;

                dfs(i, cnt + 1);

                // 교환한거 되돌리기
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            arr = sc.next().split("");
            chance = sc.nextInt();

            max =0;
            if (arr.length < chance) {
                chance = arr.length;
            }

            dfs(0, 0);

            System.out.println("#" + i + " " + max);
        }
    }
}
