package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10026_적록색약_dfs {
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {0, -1, 0, 1}; // 상하좌우 x
    static int[] dy = {-1, 0, 1, 0}; // 상하좌우 y
    static int n;
    static int RGB, nRGB;

    // <- , ↑ , -> , ↓ ... 동서남북 4방향 체크해가며 dfs 돌리기
    static void dfs(int x, int y) {
        visit[x][y] =true; // 현재 위치 방문했음 체크
        char color = map[x][y]; // 현재 색 저장

        // 상하좌우 체크
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>0 && ny>0 && nx<=n && ny<=n){
                // 상하좌우 중 같은색의 약이고 방문하지 않은곳 -> 끝까지 탐색
                if(map[nx][ny]==color && !visit[nx][ny]){
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n+1][n+1];
        visit = new boolean[n+1][n+1];


        for(int i=1; i<=n; i++){
            String s = br.readLine();
            for(int j=1; j<=n; j++){
                map[i][j] = s.charAt(j - 1);
            }
        }

        // 적록색약이 아닌 사람
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(!visit[i][j]){
                    dfs(i, j);
                    nRGB++;
                }
            }
        }

        // 적록색약인 사람은 빨간색과 초록색을 구분하지 못한다.
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j] == 'G'){
                    map[i][j] ='R';
                }
            }
        }

        visit = new boolean[n+1][n+1];	// 방문표시 초기화

        // 적록색약인 사람
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(!visit[i][j]){
                    dfs(i, j);
                    RGB++;
                }
            }
        }
        System.out.println(nRGB + " " + RGB);
    }
}
