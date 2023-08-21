package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1644_소수의연속합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N + 1]; // true면 소수가 아님.
        ArrayList<Integer> num = new ArrayList<>();

        isPrime[0] = true;
        isPrime[1] = true;

        // 소수 찾기 -> 에라토스테네스의 체
        for (int i = 2; i <= N; i++) {
            if(isPrime[i])  continue;
            for (int j = i * 2; j <= N; j+=i) {
                if(!isPrime[j]) isPrime[j]=true; // 소수가 아니다.
            }
        }

        for (int i = 0; i <= N; i++) {
            if (!isPrime[i]) {
                num.add(i); // 소수만 담은 배열
                //System.out.println("i = " + i);
            }
        }

        int cnt=0;

        if(!isPrime[N]) cnt++;
        if(N==1){
            System.out.println(0);
            return;
        }
        if (N == 2) {
            System.out.println(1);
            return;
        }

        int s = 0;
        int l = 1;
        int sum=0;
        sum = num.get(s) + num.get(l);

        while (s<l) {
            if (sum < N) {
                l++;
                sum += num.get(l);
            }else if(sum>N){
                sum-=num.get(s++);
            }
            else{
                cnt++;
                sum-=num.get(s++);
                l++;
                sum+=num.get(l);
            }
        }
        System.out.println(cnt);
    }
}
