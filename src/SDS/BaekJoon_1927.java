package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BaekJoon_1927 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> mnq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num>0){
                mnq.add(num);
            }else if(mnq.isEmpty() && num==0){
                System.out.println(0);
            }else if(num==0){
                System.out.println(mnq.poll());
            }
        }
    }
}
