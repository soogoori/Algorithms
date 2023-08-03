package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1652_누울자리를찾아라 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];

        for (int i = 0; i < N; i++) {
            String seat = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = seat.charAt(j);
            }
        }

        int rowCnt=0; // 가로
        int row=0;
        int colCnt=0; // 세로
        int col=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.' ) {
                    rowCnt++;
                }else{
                    if (rowCnt >= 2) {
                        row++;
                    }
                    rowCnt=0;
                    continue;
                }
            }
            if (rowCnt >= 2) {
                row++;
            }
            rowCnt=0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (room[j][i] == '.') {
                    colCnt++;
                }else{
                    if (colCnt >= 2) {
                        col++;
                    }
                    colCnt=0;
                    continue;
                }
            }
            if (colCnt >= 2) {
                col++;
            }
            colCnt=0;
        }
        System.out.println(row + " " + col);
    }
}
