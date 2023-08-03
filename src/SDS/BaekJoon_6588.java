package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_6588 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] check = new boolean[1000001];
        for(int i=2; i<check.length; i++){
            if(!check[i]){
                for(int j=i*2; j<check.length; j+=i){
                    check[j] = true; // 소수가 아님
                }
            }
        }

        int N;
        while((N = Integer.parseInt(br.readLine())) !=0) {


            boolean isTrue = false;
            for (int i = 2; i <= N / 2; i++) {
                if (!check[i] && !check[N - i]) {
                    System.out.println(N + " = " + i + " + " + (N - i));
                    isTrue = true;
                    break;
                }
            }
            if (!isTrue) {
                System.out.println("Goldbach's conjecture is wrong.");

            }
        }
    }
}
