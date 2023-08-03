package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon_2579_계단오르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n + 1];
        int len = stair.length;

        for(int i=1; i<=n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        // 마지막 앞에 있는 것을 고르지 않았을 때 -> ex) len=6일 때 5를 고르지 않음. -> 1~4에서 최대


        // 마지막 앞에 있는 것을 골랐을 때 -> ex) len=6일 때 5를 골랐으면 4는 고르지 못함. -> 1~3에서 최대값


    }
}
