package SDS;

import java.util.Scanner;

public class BaekJoon_2003 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int cnt = 0;
        int sum=0;
        int endPointer=0;

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        for(int startPointer = 0; startPointer<N; startPointer++){
            while(sum<M && endPointer<N){
                sum+=arr[endPointer++];
            }
            if(sum==M) {
                cnt++;
            }
            sum -= arr[startPointer];
        }
        System.out.println(cnt);
    }
}
