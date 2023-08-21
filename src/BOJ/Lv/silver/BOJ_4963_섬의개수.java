package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {

    static int w,h, answer;
    static int[][] map;
    static boolean[][] visit;
    static int[] dw = {0, 0, 1, 1, 1, -1, -1,-1};
    static int[] dh = {-1, 1, 1, -1, 0, -1, 1, 0};

    static void findLand(int a, int b){
        visit[a][b] = true;

        for(int i=0; i<=7; i++){
            int nw = b + dw[i]; // 가로
            int nh = a + dh[i]; // 세로

            if(nw>0 && nh>0 && nw<=w && nh<=h){
                if(map[nh][nw]==1 && !visit[nh][nw]){
                    findLand(nh, nw);
                }
            }
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0){
                break;
            }
            else{
                map = new int[h+1][w+1];
                visit = new boolean[h+1][w+1];

                for(int i=1; i<=h; i++){
                    st = new StringTokenizer(br.readLine());
                    for(int j=1; j<=w; j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }

            answer=0;

            for(int i=1; i<=h; i++){
                for(int j=1; j<=w; j++){
                    if(map[i][j] ==1 && !visit[i][j]){
                        findLand(i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
