package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2210_숫자판점프_bfs {

    static class Info{
        int x,y;
        String str;

        public Info(int x, int y, String str) {
            this.x = x;
            this.y = y;
            this.str =str;
        }
    }

    static int[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Set<String> numSet = new HashSet<>();

    static void findNum(int a, int b, String num){

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(a, b, num));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(num.length()==6){
                numSet.add(num);
                continue;
            }
            for(int i=0; i<4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];

                if (nx > 0 && ny > 0 && nx <= 5 && ny <= 5) {
                    queue.add(new Info(nx, ny, num + board[nx][ny]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[6][6];

        for(int i=1; i<=5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=5; i++){
            for(int j=1; j<=5; j++){
                findNum(i, j, board[i][j]+"");
            }
        }

        for (String s : numSet) {
            System.out.println("s = " + s);
        }
        System.out.println(numSet.size());

    }
}
