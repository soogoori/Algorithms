package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_13428_숫자조작 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {

            String str = br.readLine();
            char[] chars = str.toCharArray();

            int min = Integer.parseInt(str);
            int max = min;

            for (int j = 0; j < str.length()-1; j++) {
                for(int k=j+1; k<str.length(); k++){
                    char temp = chars[j];
                    chars[j] = chars[k];
                    chars[k] = temp;

                    if (chars[0] != '0' && Integer.parseInt(String.valueOf(chars)) <= min) {
                        min = Integer.parseInt(String.valueOf(chars));
                    }
                    if (chars[0] != '0' && Integer.parseInt(String.valueOf(chars)) > max) {
                        max = Integer.parseInt(String.valueOf(chars));
                    }

                    temp = chars[j];
                    chars[j] = chars[k];
                    chars[k] = temp;
                }
            }

            bw.write("#" + i + " " + min +" "+max + "\n");
        }

        bw.flush();
        bw.close();
    }
}
