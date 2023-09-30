package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_3750_DigitSum {

    static int num=0;
    static void sum(String s) {

        if (s.length() == 1) {
            return;
        }
        num=0;

        for (int i = 0; i < s.length(); i++) {
            num += s.charAt(i) - '0';
        }
        sum(String.valueOf(num));

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {

            String str = br.readLine();
            if(str.length()==1) num = Integer.parseInt(str);
            else sum(str);

            bw.write("#" + i + " " + num + "\n");
        }
        bw.flush();
        bw.close();
    }
}
