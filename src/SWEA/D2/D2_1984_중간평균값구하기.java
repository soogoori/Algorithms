package SWEA.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_1984_중간평균값구하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        long result =0;
        int[] num = new int[10];

        for (int i = 1; i <= T; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num);

            int sum=0;

            for (int j = 1; j < 9; j++) {
                sum+=num[j];
            }

            result = Math.round(sum / 8.0);

            bw.write("#" + i + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
