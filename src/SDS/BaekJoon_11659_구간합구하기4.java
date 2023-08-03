package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon_11659_구간합구하기4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n+1];
        int[] total = new int[n + 1];
        int sum=0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            num[i] = Integer.parseInt(st.nextToken());
            sum += num[i];
            total[i] = sum;
        }

        int answer= 0;
        for(int k=0; k<m; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            answer = total[j] - total[i - 1];
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
