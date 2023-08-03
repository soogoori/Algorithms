package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_1644_my {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] prime = new int[4000001];
        int[] primeList = new int[100001]; // 소수 목록
        int l=1;
        int r=1;
        int p=0;
        int cnt=0;

        // 소수 판별
        for(int i=2; i<=N; i++){
            if(prime[i]==0){
                primeList[++p]=i;
                for(int j=i*2; j<=N; j+=i){
                    prime[j]=1;
                }
            }
        }

        int sum=primeList[1];
        // 투 포인터로 이동하면서 확인
        while(r<=p){
            if(sum<N){
                r++;
                sum += primeList[r];
            }else if(sum>=N){
                if(sum==N){
                    cnt++;
                }
                sum -= primeList[l];
                l++;
            }
        }
        System.out.println(cnt);
    }
}
