package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {

    static boolean[] visit;
    static int[] getLottoNum;
    static int[] S;
    static int k;

    static void lotto(int start, int depth){

        if(depth == 6) {
            for (int i : getLottoNum) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                getLottoNum[depth] = S[i];
                lotto(i, depth + 1);
                visit[i]=false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        getLottoNum = new int[6];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                return;
            }

            S = new int[k];
            visit = new boolean[k];

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            lotto(0, 0);

            System.out.println();
        }
    }
}
