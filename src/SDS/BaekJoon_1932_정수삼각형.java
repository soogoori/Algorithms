package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon_1932_정수삼각형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n+1][n+1];
        int[][] d = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max =0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                d[i][j] = tri[i][j] + Math.max(d[i-1][j-1], d[i-1][j]);
            }
        }

        for(int i=1; i<=n; i++){
            max = Integer.max(max, d[n][i]);
        }

        //System.out.println(max);
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
