package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon_11404_플로이드 {

    static int n, m;
    static int[][] list;
    static StringBuffer answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new int[n + 1][n + 1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(list[a][b]==0 || list[a][b] > c){
                list[a][b] = c;
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(j!=k && list[j][i]!=0 && list[i][k]!=0){
                        if (list[j][k] == 0 || list[j][k] > list[j][i] + list[i][k]) {
                            list[j][k] = list[j][i] + list[i][k];
                        }
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            answer = new StringBuffer();
            for(int j=1; j<=n; j++){
                answer.append(list[i][j] + " ");
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
