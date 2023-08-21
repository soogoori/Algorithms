package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DFS
 */
public class BOJ_1926_그림_dfs {

    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int n, m, nPic, cntPic, maxPic;
    static int[][] paper;
    static boolean[][] visit;

    public static void findPic(int a, int b){
        visit[a][b]=true;

        for(int i=0; i<4; i++){
            int nx = a + dx[i];
            int ny = b + dy[i];

            if(nx>0 && ny>0 && nx<=n && ny<=m){
                if(paper[nx][ny]==1 && !visit[nx][ny]){
                    cntPic++;
                    findPic(nx, ny);
                }
            }
        }

        if(cntPic>=maxPic){
            maxPic = cntPic;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(paper[i][j]==1 && !visit[i][j]){
                    cntPic=1;
                    findPic(i, j);
                    nPic++;
                }
            }
        }
        System.out.println("nPic = " + nPic);
        System.out.println("maxPic = " + maxPic);
    }
}
