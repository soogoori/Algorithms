package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS
 */
public class BOJ_1926_그림_bfs {

    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int n, m, nPic, cntPic, maxPic;
    static int[][] paper;
    static boolean[][] visit;

    static class Info{
        private int x;
        private int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void findPic(int a, int b){

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(a, b));

        visit[a][b]=true;

        while(queue.size()>0){
            Info now = queue.poll();
            int curX = now.getX();
            int curY = now.getY();

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx>0 && ny>0 && nx<=n && ny<=m){
                    if(paper[nx][ny]==1 && !visit[nx][ny]){
                        cntPic++;
                        visit[nx][ny]=true;
                        queue.add(new Info(nx, ny));
                    }
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
