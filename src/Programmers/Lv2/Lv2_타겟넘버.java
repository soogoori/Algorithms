package Programmers.Lv2;

/**
 * DFS, BFS 모두 가능
 * 다시 풀어보기
 */

public class Lv2_타겟넘버 {

    static int[] numbers;
    static int target;

    public static void main(String[] args) {
        numbers = new int[]{4, 1, 2, 1};
        int target = 4;

        System.out.println(solution(numbers, target));
    }

    public static void dfs(int depth, int sum){

        if (depth == numbers.length) {

        }


    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(0, 0);

        return answer;
    }
}
