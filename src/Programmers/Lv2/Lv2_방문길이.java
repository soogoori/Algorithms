package Programmers.Lv2;

/**
 * 해당 칸 방문 시 어느 방향으로 오느냐가 관건 !
 */
public class Lv2_방문길이 {
    public static void main(String[] args) throws Exception {
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }

    public static int solution(String dirs) {
        int answer = 0;

        boolean[][][] visit = new boolean[11][11][4];
        int x=5, y=5;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        for (int i = 0; i < dirs.length(); i++) {
            int d = 0;
            String s= String.valueOf(dirs.charAt(i));
            switch (s) {
                case "U" :
                    d=0;
                    break;
                case "L" :
                    d=1;
                    break;
                case "R" :
                    d=2;
                    break;
                case "D" :
                    d=3;
                    break;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx <= 10 && ny <= 10 && !visit[nx][ny][d]) {
                visit[nx][ny][d] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }

        return answer;
    }
}
