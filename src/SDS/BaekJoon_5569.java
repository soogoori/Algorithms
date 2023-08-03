package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_5569 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // w-1번 + h-1번 이동
        // 조건이 없을 경우에는 조합 w-1Ch-1

        // 1. 어느 방향에서 왔는지
        // 2. 이전에 올 때 전환점을 돌았는지
        // 하나의 노드에 대해서 4가지 경우 고려해야 함.
       int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
    }
}
