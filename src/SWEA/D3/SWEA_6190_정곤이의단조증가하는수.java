package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_6190_정곤이의단조증가하는수 {

    static int result;
    static int[] a;
    static boolean check(int i, int j) {

        String d = String.valueOf(a[i]*a[j]);

        int[] dk = new int[d.length()];

        for (int a = 0; a < dk.length; a++) {
            dk[a] = d.charAt(a) - '0';
        }

        for (int a = 0; a < dk.length-1; a++) {
            if (dk[a] <= dk[a + 1]) {
                continue;
            }else return false;
        }
        result = Integer.parseInt(d);
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            a = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            for (int j = 0; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (check(j, k)) {
                        max = Math.max(max, result);
                    }
                }
            }

            if (max == 0) {
                max=-1;
            }

            bw.write("#" + i + " " + max + "\n");
        }
        bw.flush();
        bw.close();
    }
}
