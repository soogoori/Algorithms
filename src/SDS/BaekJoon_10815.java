package SDS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이진탐색
 */
public class BaekJoon_10815 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nArr = new int[N];

        for(int i=0; i<N; i++){
            nArr[i] = sc.nextInt();
        }

        Arrays.sort(nArr);

        int M = sc.nextInt();


        for(int i=0; i<M; i++){
            int temp = sc.nextInt();
            System.out.print(binarySearch(nArr, N, temp)+ " ");
        }
    }

    public static int binarySearch(int[] cards, int N, int search){
        int first = 0;
        int last = N-1;
        int mid =0;

        while(first<=last){
            mid = (first+last)/2;

            if(cards[mid] == search) {
                return 1;
            }
            else if(cards[mid] > search){
                last = mid-1;
            }
            else {
                first = mid + 1;
            }
        }
        return 0;
    }
}
