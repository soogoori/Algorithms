package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 일일이 다 해봐야하는군....
 */
public class BOJ_14502_연구소 {

    static int N, M;
    static int[][] map;
    static int[][] virusMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = Integer.MIN_VALUE;

    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 벽 세우기 → 완전탐색 → 백트래킹
    public void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] =1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 퍼트리기
    public void bfs() {
        Queue<Node> queue = new LinkedList<>();
        virusMap = new int[N][M]; // 벽이 3개 세워질 때마다 bfs 실행 → 벽이 세워진 map을 복사해서 사용 (초기화 용도)

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = map[i][j];
                if (virusMap[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && virusMap[nx][ny] == 0) {
                    virusMap[nx][ny] = 2;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        int cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        max = Math.max(cnt, max);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
