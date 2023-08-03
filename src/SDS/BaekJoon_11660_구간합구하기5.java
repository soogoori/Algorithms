package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon_11660_구간합구하기5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] table = new int[n + 1][n + 1];
        int[][] total = new int[n + 1][n + 1]; // 누적값

        for(int i =1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                total[i][j] = table[i][j] + total[i - 1][j] + total[i][j - 1] - total[i - 1][j - 1];
            }
        }
        int answer=0;
        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            answer = total[x2][y2] - total[x1 - 1][y2] - total[x2][y1 - 1] + total[x1 - 1][y1 - 1];
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
