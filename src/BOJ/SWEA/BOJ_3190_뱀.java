package BOJ.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class BOJ_3190_뱀 {

    static int N, K, L, timeCnt;
    static int[][] board;
    static Queue<DirectInfo> direction;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서 -> 0123
    static int[] dy = {0, 1, 0, -1};
    static class DirectInfo{
        int time;
        char dir;

        public DirectInfo(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static class Info{
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void game(){
        Deque<Info> deq = new LinkedList<>();
        deq.add(new Info(1, 1));

        int nowDir = 1; // 동쪽(오른쪽) 바라보고 있음
        DirectInfo directInfo = direction.poll();

        int t=directInfo.time;
        char d = directInfo.dir;

        while(!deq.isEmpty()){

            Info info = deq.peekLast(); // 가장 최근에 삽입된 것 확인

            // 몸길이 늘리기
            int nx = info.x + dx[nowDir];
            int ny = info.y + dy[nowDir];

            timeCnt++;

            // 벽에 닿거나 뱀이 본인 몸에 닿으면 끝 !
            if (nx > 0 && ny > 0 && nx <= N && ny <= N) { // 벽에 안닿긴 함 -> 몸에 닿는지 확인
                for (Info element : deq) {
                    if (nx == element.x && ny == element.y) {
                        return;
                    }
                }
            }else{ // 벽에 닿음 -> 끝
                return;
            }

            // 사과가 있을 때 길이 늘어나기 && 사과 없으면 꼬리 부분 지우기
            if (board[nx][ny] != 1) { // 사과 없음 -> 꼬리가 위치한 부분 없애기
                deq.pollFirst();
            } else { // 사과 있음 -> 사과 먹어서 없애버리기
                board[nx][ny] = 0;
            }
            deq.add(new Info(nx, ny));

            if (timeCnt == t) { // 방향 바꿀 시간~~
                if (d == 'D') { // 오른쪽
                    nowDir = (nowDir+1)%4;
                } else { // 왼쪽
                    nowDir = (nowDir+3)%4;
                }
                if (!direction.isEmpty()) {
                    directInfo = direction.poll();
                    t = directInfo.time;
                    d = directInfo.dir;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N+1][N+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken()); // 행
            int col = Integer.parseInt(st.nextToken()); // 열

            board[row][col] = 1; // 사과가 있는 곳
        }

        direction = new LinkedList<>();

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            direction.add(new DirectInfo(t, d)); // 방향변환에 대한 정보 저장
        }
        game();
        bw.write(timeCnt + " ");
        bw.flush();
        bw.close();
    }
}
