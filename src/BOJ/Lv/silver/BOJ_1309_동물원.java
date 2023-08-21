package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1309_동물원 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cage = new int[100001];

        cage[1] = 3;
        cage[2] = 7;

        for (int i = 3; i <= N; i++) {
            cage[i] = (cage[i-2] + cage[i-1]*2)%9901;
        }
        System.out.println(cage[N]);
    }
}
