package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 최대공약수 -> 유클리드 호제법
 */
public class SWEA_17937_큰수의최대공약수 {

    /*static long GCD(long a, long b) {

        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }*/
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {

            st = new StringTokenizer(br.readLine());

            BigInteger A = new BigInteger(st.nextToken());
            BigInteger B = new BigInteger(st.nextToken());

            BigInteger result = A.gcd(B);

            bw.write("#" + i + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
