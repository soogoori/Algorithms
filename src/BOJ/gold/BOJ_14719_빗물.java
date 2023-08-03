package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실패 .. 다시 시도 필요
 */
public class BOJ_14719_빗물 {

    static int H, W;
    static int[] world;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        world = new int[W];
        int answer=0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            world[i] = Integer.parseInt(st.nextToken());
        }


        System.out.println(answer);
    }
}
