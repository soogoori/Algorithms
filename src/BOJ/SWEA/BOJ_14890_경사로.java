package BOJ.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 구현
 */
public class BOJ_14890_경사로 {

    static int N, L;
    static int[][] map;
    static int ok;

    static boolean checkRow(int x){

        boolean[] isIncline = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = map[x][i] - map[x][i + 1];

            if (diff >= 2 || diff <= -2) return false; // 경사로 높이가 2 이상이면 안됨
            else if (diff == -1) { // 경사로 올라감
                for (int j = 0; j < L; j++) {
                    if ((i - j) < 0 || isIncline[i - j]) return false; // 경사로 범위를 벗어나거나 이미 경사로가 설치되었다면 안됨
                    if (map[x][i] != map[x][i - j]) return false; // 경사로가 설치될 곳이 평평하지 않다면 안됨
                    isIncline[i-j] = true; // 위의 예외사항을 통과하면 경사로 설치 가능
                }

            } else if (diff == 1) { // 경사로 내려감
                for (int j = 1; j <= L; j++) {
                    if ((i + j) >= N || isIncline[i + j]) return false;
                    if(map[x][i] -1 !=map[x][i+j])  return false;
                    isIncline[i+j] = true;
                }
            }
        }
        return true; // 위의 예외사항을 다 통과해야 경사로를 이용해 걸어갈 수 있음.
    }

    static boolean checkCol(int y){

        boolean[] isIncline = new boolean[N];

        for (int i = 0; i < N-1; i++) {
            int diff = map[i][y] - map[i + 1][y];

            if(diff>=2 || diff<=-2) return false;
            else if (diff == 1) { // 경사로 내려감
                for (int j = 1; j <= L; j++) {
                    if(i+j>=N || isIncline[i+j])    return false;
                    if(map[i][y] -1 != map[i+j][y]) return false;
                    isIncline[i + j] = true;
                }
            } else if (diff == -1) { // 경사로 올라감
                for (int j = 0; j < L; j++) {
                    if(i-j<0 || isIncline[i-j]) return false;
                    if (map[i][y] != map[i-j][y]) return false;
                    isIncline[i-j] = true;
                }
            }
        }
        return true;
    }

    //d=0 이면 행 검사, d=1이면 열 검사
    static boolean canGo(int x, int y, int d) {
        int[] height = new int[N];
        boolean[] visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            height[i] = (d == 0) ? map[x][y + i] : map[x+i][y];
        }

        for (int i = 0; i < N-1; i++) {
            int diff = height[i] - height[i + 1];
            if (Math.abs(diff)>=2) return false;
            if (height[i]==height[i + 1]) continue;
            if (diff== 1) { // 경사로 내려감
                for (int j = i + 1; j <= L; j++) {
                    if(height[j]!=height[i+1] || j>=N || visit[j])  return false;
                    visit[j] = true;
                }
            } else if (diff == -1) { // 경사로 올라감
                for (int j = i; j > i-L; j--) {
                    if(j<0 || height[i] != height[j] || visit[j])   return false;
                    visit[j] = true;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            if(checkRow(i)) ok++;
            if(checkCol(i)) ok++;
        }

        /*for (int i=0; i<N; i++) {
            if (canGo(i, 0, 0))
                ok++;

            if (canGo(0, i, 1))
                ok++;
        }*/

        bw.write(ok + " ");
        bw.flush();
        bw.close();
    }
}
