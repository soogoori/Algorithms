package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {

    static int l, cnt;
    static int[][] board;
    static boolean[][] visit;
    static int nowX, nowY, nextX, nextY;
    static int[] dx ={1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dy ={2, -2, -2, 2, 1, -1, -1, 1};


    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(){

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(nowX, nowY));

        while(!queue.isEmpty()){
            Point now = queue.poll();
            if (now.x == nextX && now.y == nextY) {
                break;
            }
            for(int i=0; i<8; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx>=0 && ny>=0 && nx<l && ny<l && !visit[nx][ny]){
                    if (board[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        board[nx][ny] = board[now.x][now.y] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){
            l = Integer.parseInt(br.readLine());

            board = new int[l][l];
            visit = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            nowX = Integer.parseInt(st.nextToken());
            nowY = Integer.parseInt(st.nextToken());

            visit[nowX][nowY] = true;

            st = new StringTokenizer(br.readLine());
            nextX = Integer.parseInt(st.nextToken());
            nextY = Integer.parseInt(st.nextToken());

            bfs();

            System.out.println(board[nextX][nextY]);
        }
    }
}
