package Programmers.Lv1;

import java.util.Stack;

public class Lv1_크레인인형뽑기게임 {
    public static void main(String[] args) throws Exception {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        int now =0;
        int before=0;
        int cnt=0;

        for (int i = 0; i < moves.length; i++) {
            if (basket.size() >= 1) {
                before = basket.peek();
            }
            cnt=0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i]-1] != 0) {
                    basket.push(board[j][moves[i]-1]);
                    now= board[j][moves[i]-1];
                    board[j][moves[i]-1]=0;
                    break;
                }
                cnt++;
            }
            if (cnt!=board.length && basket.size() > 1){
                if (now == before) {
                    basket.pop();
                    basket.pop();
                    answer+=2;
                }
            }
        }

        return answer;
    }
}
