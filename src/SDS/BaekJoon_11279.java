package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BaekJoon_11279 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> mxq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num>0){
                mxq.add(num);
            }else if(mxq.isEmpty() && num==0){
                System.out.println(0);
            }else if(num==0){
                System.out.println(mxq.poll());
            }
        }
    }
}
