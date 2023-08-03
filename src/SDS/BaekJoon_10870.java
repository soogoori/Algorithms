package SDS;

import java.util.Scanner;

public class BaekJoon_10870 {

    static int answer;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibo(n));

    }

    static int fibo(int x){
        if(x==0){
            return 0;
        }else if(x==1){
            return 1;
        }else{
            answer = fibo(x - 1) + fibo(x - 2);
            return answer;
        }
    }
}
