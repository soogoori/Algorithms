package BOJ.Lv.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10798_세로읽기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] alpha = new char[5][15];
        String answer="";

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                alpha[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (alpha[j][i]!=0) {
                    answer += alpha[j][i];
                }
            }
        }
        System.out.println(answer);
    }
}
