package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 구현 문제
 */
public class BOJ_7682_틱택토 {

    static boolean check(char[] board){

        int cntX =0, cntO=0, ansO=0, ansX=0;

        // 개수 비교
        for (int i = 0; i < 9; i++) {
            if (board[i] == 'X') {
                cntX++;
            } else if (board[i] == 'O') {
                cntO++;
            }
        }

        if(cntX-cntO !=1 && cntX-cntO !=0)  return false;

        // 가로
        for (int i = 0; i < 9; i+=3) {
            if(board[i] == '.') continue;
            if (board[i] == board[i + 1] && board[i + 1] == board[i + 2]) {
                if (board[i] == 'X') {
                    ansX++;
                }else   ansO++;
            }
        }

        // 세로
        for (int i = 0; i < 3; i++) {
            if(board[i] == '.') continue;
            if (board[i] == board[i + 3] && board[i + 3] == board[i + 6]) {
                if (board[i] == 'X') {
                    ansX++;
                }else   ansO++;
            }
        }

        // 대각선
        if (board[4] != '.') {
            if ((board[4] == board[0] && board[4] == board[8]) ||
                    board[4] == board[2] && board[4] == board[6]) {
                if (board[4] == 'X') {
                    ansX++;
                } else ansO++;
            }
        }

        if (ansX > 0) {
            if (ansO > 0) return false;
            if (cntX - cntO == 1) return true;
            else return false;
        }
        if (ansO > 0) {
            if (cntX - cntO == 0) return true;
            else return false;
        }
        if (cntX + cntO == 9) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String st = br.readLine();
            if(st.equals("end"))    break;

            char[] board = new char[9];
            for (int i = 0; i < 9; i++) {
                board[i] = st.charAt(i);
            }

            if (check(board)) {
                System.out.println("valid");

            }else System.out.println("invalid");
        }
        return;
    }
}
