package Programmers.Lv2;

/**
 * DFS, BFS 모두 가능
 * 다시 풀어보기
 */

public class Lv2_타겟넘버 {
    static int answer;

    public static void main(String[] args) {
        int[] numbers = new int[]{1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static void dfs(int[] numbers, int depth, int target, int sum){

        if (depth == numbers.length) {
            if (target == sum) {
                answer++;
            }
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }

    public static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, target, 0);
        return answer;
    }
}
