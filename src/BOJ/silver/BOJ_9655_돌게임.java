package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9655_돌게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1 || N == 2 || N == 3) {
            System.out.println("SK");
            return;
        }

        if (N % 2 == 0) {
            System.out.println("CY");
            return;
        } else {
            System.out.println("SK");
            return;
        }
    }
}
