package SDS;

import java.util.Scanner;

public class BaekJoon_2748 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] answer = new long[91];
        answer[0] = 0;
        answer[1] = 1;

        for(int i=2; i<=n; i++){
            answer[i] = answer[i-1] + answer[i-2];
        }
        System.out.println(answer[n]);

    }
}
