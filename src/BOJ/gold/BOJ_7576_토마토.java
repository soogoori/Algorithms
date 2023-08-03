package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0이 남아있으면 안됨 -> 방문했으면 무언가로 대체해야 함 .
 * BFS
 */
public class BOJ_7576_토마토 {

    static int m,n;
    static int[][] storage;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Info> queue;


    static class Info{
        int x,y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(){

        while(queue.size()>0){
            Info now = queue.poll();

            int x = now.x; // 세로
            int y = now.y; // 가로

            for(int i=0; i<4; i++){
                int nx = x+ dx[i]; // 세로
                int ny = y + dy[i]; // 가로

                if (nx > 0 && ny > 0 && nx <= n && ny <= m) {
                    if(storage[nx][ny]==0){
                        queue.add(new Info(nx, ny));
                        storage[nx][ny] = storage[x][y] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(storage[i][j]==0){
                    return -1;
                }
                result = Math.max(result, storage[i][j]);
            }
        }

        if(result==1){
            return 0;
        }else{
            return result-1;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로

        storage = new int[n+1][m+1];
        queue = new LinkedList<Info>();

        // 1:익은 토마토, 0:익지 X, -1:빈칸
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                storage[i][j] = Integer.parseInt(st.nextToken());
                // 만약 토마토가 익었으면 큐에 넣기
                if(storage[i][j]==1){
                    queue.add(new Info(i, j));
                }
            }
        }
        System.out.println(bfs());
    }
}
