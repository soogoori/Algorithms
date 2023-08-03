package SDS;

import java.util.Scanner;

public class BaekJoon_9663 {
    static int N = 0;
    static int answer = 0;

    static int[] line = new int[16];

    // x-y & x+y
    static int[] diRight = new int[33];
    static int[] diLeft = new int[33];

    static void back(int x){

        if(x==N+1){
            answer++;
            return;
        }

        for(int i=1; i<=N; i++){
            if(line[i]==0 && diRight[x-i+N]==0 && diLeft[x+i]==0){
                line[i] = 1;
                diRight[x-i+N]=1;
                diLeft[x+i] = 1;
                back(x+1);
                line[i]=0;
                diRight[x-i+N]=0;
                diLeft[x+i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        back(1);
        System.out.println(answer);
    }
}
