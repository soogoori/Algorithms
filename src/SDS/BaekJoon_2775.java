package SDS;

import java.util.Scanner;
public class BaekJoon_2775 {

    static int T;
    static int k;
    static int n;

    static int[][] arr = new int[14][14];

    private static int back(int x, int y) {
        if (x == 0) {
            return y;
        }else if(y==0){
            return 0;
        }else{
            return back(x, y - 1) + back(x - 1, y);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for(int i=0; i<T; i++){
            k = sc.nextInt();
            n = sc.nextInt();

            System.out.println(back(k, n));
        }
    }
}
