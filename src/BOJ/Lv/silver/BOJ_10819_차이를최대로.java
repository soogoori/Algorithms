package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ArrayDeque 사용해서 풀었다 !
 */
public class BOJ_10819_차이를최대로 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        ArrayDeque<Integer> adq = new ArrayDeque<>();

        adq.add(arr[0]);
        adq.add(arr[N - 1]);

        int i =1;
        int j=N-2;

        while (i < j) {

            int num1= Math.abs(arr[i]-adq.getFirst())+Math.abs(arr[j]-adq.getLast());
            int num2 =Math.abs(arr[i]-adq.getLast())+Math.abs(arr[j]-adq.getFirst());

            if (num1 > num2) {
                adq.addFirst(arr[i]);
                adq.addLast(arr[j]);

            }else{
                adq.addFirst(arr[j]);
                adq.addLast(arr[i]);
            }
            i++;
            j--;
        }

        if(i==j){
            int num1= Math.abs(arr[i]-adq.getFirst());
            int num2 =Math.abs(arr[i]-adq.getLast());

            if (num1 > num2) {
                adq.addFirst(arr[i]);

            }else{
                adq.addLast(arr[i]);
            }
        }

        for (Integer integer : adq) {
            System.out.println("integer = " + integer);
        }

        int sum = 0;
        for(int m=0; m<N; m++){
            arr[m] = adq.poll();
        }

        for(int m=0; m<N-1; m++){
            sum += Math.abs(arr[m] - arr[m + 1]);
        }
        System.out.println("sum = " + sum);
    }
}
