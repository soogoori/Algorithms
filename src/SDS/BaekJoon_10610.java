package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 3의 배수인지
// 0이 있는지

public class BaekJoon_10610 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //int N = Integer.parseInt(br.readLine());
        String n =br.readLine();
        boolean three = false;
        boolean zero = false;
        String[] nStr = new String[n.length()];

        // 각 자리 수의 합이 3의 배수인지 확인
        int sum=0;
        for(int i=0; i<n.length(); i++){
            if(n.charAt(i)=='0'){
                zero=true;
            }
            sum+=n.charAt(i)-'0';
        }
        if((sum%3==0)){
            three = true;

        }
        if(three && zero){
            nStr = n.split("");
            Arrays.sort(nStr, Collections.reverseOrder());
            String answer= String.join("", nStr);
            System.out.println(answer);
        }else{
            System.out.println(-1);
            return;
        }
    }
}
