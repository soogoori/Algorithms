package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * 미완성
 */
public class BOJ_10026_적록색약_bfs {
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {0, -1, 0, 1}; // 상하좌우 x
    static int[] dy = {-1, 0, 1, 0}; // 상하좌우 y
    static int n;
    static int RGB, nRGB;

    static void bfs(){
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        adq.add(1);
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
                    //bfs(i, j);
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
                    //bfs(i, j);
                    RGB++;
                }
            }
        }
        System.out.println(nRGB + " " + RGB);
    }
}
