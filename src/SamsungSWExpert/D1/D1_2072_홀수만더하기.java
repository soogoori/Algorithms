package SamsungSWExpert.D1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D1_2072_홀수만더하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int sum=0;
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num % 2 != 0) {
                    sum += num;
                }
            }

            bw.write("#" + i + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}
