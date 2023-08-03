package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * D[i][j] = Num[i][j]가 1일 때만 연산
 * 동적계획법
 */
public class BaekJoon_1915_가장큰정사각형 {
    static int n, m;
    static int[][] num;
    static int[][] d;
    static int answer;

    static void dp(){
        for(int i=1; i<=n; i++){
            for (int j = 1; j <= m; j++) {
                if(num[i][j]==1){
                    d[i][j] = Math.min(Math.min(d[i - 1][j], d[i - 1][j - 1]),d[i][j - 1]) +1;
                    answer = Math.max(answer, d[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n + 1][m + 1];
        d = new int[n + 1][m + 1];

        for(int i=1; i<=n; i++){
            String input = br.readLine();
            for (int j = 1; j <= n; j++) {
                num[i][j] = input.charAt(j-1)-'0';
            }
        }

        dp();

        System.out.println(answer*answer);

    }

}
