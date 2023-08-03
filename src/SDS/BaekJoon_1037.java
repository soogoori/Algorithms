package SDS;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_1037 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] realYaksoo = new int[N];

        for(int i=0; i<N; i++){
            realYaksoo[i] = sc.nextInt();
        }

        Arrays.sort(realYaksoo);

        int answer = realYaksoo[0] * realYaksoo[N-1];

        System.out.println("answer = " + answer);

    }
}
