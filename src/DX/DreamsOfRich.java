package DX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DreamsOfRich {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int[][] cell = new int[N+1][M+1];
            int[] row = new int[N+1];
            int[] col = new int[M+1];
            //boolean[][] visit = new boolean[N+1][M+1];
            boolean[] visitRow = new boolean[N + 1];
            boolean[] visitCol = new boolean[M+1];

            int[] dp = new int[Q + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++) {
                    cell[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= N; i++) {
                int maxRow =1;
                for (int j = 1; j <= M; j++) {
                    maxRow = Math.max(maxRow, cell[i][j]);
                    row[i] = maxRow;
                }
            }

            for (int i = 1; i <= M; i++) {
                int maxCol =1;
                for (int j = 1; j <= N; j++) {
                    maxCol = Math.max(maxCol, cell[j][i]);
                    col[i] = maxCol;
                }
            }

            int safe=0;

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if (cell[j][k] >= row[j] && cell[j][k] >= col[k]) {
                        safe++;
                        visitCol[k]=true;
                        visitRow[j] = true;
                    }
                }
            }
            dp[0] = safe;

            int preC=0;
            int preR=0;
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                cell[r][c] = x;

                // 큰 값 갱신
                // row[r - 1] = Math.max(row[r - 1], cell[r][c]);
                // col[c - 1] = Math.max(col[c - 1], cell[r][c]);

                if (row[r] <= cell[r][c] && col[c] <= cell[r][c]) {

                    if (visitCol[c] && visitRow[r] && !(preC==c && preR==r)){
                        dp[i+1] = dp[i]- 1;
                    } else if (visitCol[c] || visitRow[r])  {
                        dp[i + 1] = dp[i];
                    } else {
                        dp[i + 1] = dp[i] + 1;
                    }
                    col[c] = row[r] = cell[r][c];
                } else {
                    dp[i + 1] = dp[i];
                }
                //visit[r][c] = true;
                visitCol[c]=true;
                visitRow[r] =true;
                preC = c;
                preR = r;
            }

            int answer=0;

            for (int i = 1; i <= Q; i++) {
                System.out.println("dp[i] = " + dp[i]);
                answer+=dp[i];
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
