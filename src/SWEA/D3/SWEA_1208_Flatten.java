package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 1; i <= 10; i++) {

            int result=0;
            int dump = Integer.parseInt(br.readLine());
            int[] box=  new int[100];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                box[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < dump; j++) {
                Arrays.sort(box);
                box[99]--;
                box[0]++;
            }

            Arrays.sort(box);
            result = box[99]-box[0];

            bw.write("#" + i + " " + result + "\n");

        }
        bw.flush();
        bw.close();
    }
}
