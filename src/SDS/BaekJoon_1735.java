package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1735 {

    static int gcd(int a, int b){
        int r= Math.max(a,b)%Math.min(a,b);
        if(r==0){
            return Math.min(a,b);
        }else{
            return gcd(Math.min(a, b), r);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int A1 = Integer.parseInt(st.nextToken());
        int B1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int A2 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());

        int A = A1*B2 + A2*B1;
        int B = B1*B2;

        System.out.println(A/gcd(A,B) + " " + B/gcd(A,B));
    }
}
