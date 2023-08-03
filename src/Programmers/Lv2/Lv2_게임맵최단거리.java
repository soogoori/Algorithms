package Programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_게임맵최단거리 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Info{
        int x, y;
        int distance;

        public Info(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args){

        int[][] maps = {{1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1}};

        System.out.println(solution(maps));
    }

    static int bfs(int n, int m, boolean[][] visit, int[][] maps){
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(0, 0, 1));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i]+now.x;
                int ny = dy[i]+now.y;
                int dist=now.distance+1;

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny]) {
                    if (maps[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        queue.add(new Info(nx, ny, dist));
                    } else {
                        continue;
                    }
                }
                if (nx == n - 1 && ny == m - 1) {
                    return dist;
                }
            }
        }
        return -1;
    }

    public static int solution(int[][] maps) {
        int answer;

        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visit = new boolean[n][m];

        answer = bfs(n, m, visit, maps);

        return answer;
    }

}
