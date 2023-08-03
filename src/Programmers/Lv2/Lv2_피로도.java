package Programmers.Lv2;

/**
 * 순열 → 모든 경우의 수 탐색
 */
public class Lv2_피로도 {

    static boolean[] visit;
    static int cnt;

    public static void main(String[] args){

        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons));
    }

    static void dfs(int depth, int[][] dungeons, int fatigue){

        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && dungeons[i][0]<=fatigue) {
                visit[i] = true;
                dfs(depth + 1, dungeons, fatigue - dungeons[i][1]);
                visit[i] = false;
            }
        }
        cnt = Math.max(cnt, depth);
    }

    public static int solution(int k, int[][] dungeons) {
        int answer = 0;
        visit = new boolean[dungeons.length];
        dfs(0, dungeons, k);

        answer = cnt;
        return answer;
    }
}
