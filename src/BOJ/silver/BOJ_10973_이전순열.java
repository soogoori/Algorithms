package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10973_이전순열 {

    static int[] arr;
    static int N;

    static boolean pre_permutation(){
        int i= N-1;
        while (i > 0 && arr[i] >= arr[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }

        int j=N-1;
        while (arr[i-1] < arr[j]) {
            j--;
        }
        int temp = arr[j];
        arr[j] = arr[i-1];
        arr[i-1] = temp;

        j=N-1;
        while (i < j) {
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j--;
            i++;
        }

        return true;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (pre_permutation()) {
            for (int i : arr) {
                System.out.print(i+ " ");
            }
        }else{
            System.out.println(-1);
        }

    }
}
