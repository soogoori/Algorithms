package SWEA.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 거꾸로 생각하기
 */
public class D2_1859_백만장자프로젝트 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {

            int N = Integer.parseInt(br.readLine());
            int[] num = new int[N];

            int result =0;
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            int max = num[N - 1];

            for (int j = N - 1; j >= 0; j--) {
                if (max < num[j]) {
                    max = num[j];
                }
                result += max - num[j];
            }

            bw.write("#" + i + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
