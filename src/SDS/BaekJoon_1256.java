package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1256 {

    static String str;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 파스칼 삼각형
        int p[][] = new int[201][201];
        p[0][0]=1;
        for(int i=1; i<=N+M; i++){
            p[i][0]=1;
            for(int j=1; j<=i; j++){
                p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
                if(p[i][j]>K){
                    p[i][j] = K+1;
                }
            }
        }

        str = "";

        if(p[N+M][N]<K){
            System.out.println(-1);
            return;
        }

        int pos = N;
        int acnt=0;
        int zcnt=0;

        for(int i=N+M; i>=1; i--){
            if(pos==0){
                while((acnt!=N) || (zcnt!=M)){
                    if(acnt!=N){
                        str += "a";
                        acnt++;
                    }else if(zcnt!=M){
                        str += "z";
                        zcnt++;
                    }
                }
                System.out.println(str);
                return;
            }
            if(p[i-1][pos-1]>=K){
                str += "a";
                acnt++;
                pos--;
            }else{
                str += "z";
                zcnt++;
                K -= p[i-1][pos - 1];
            }
        }
        System.out.println(str);
    }
}




/*    int p[][] = new int[202][202];

for(int i=1;i<=N+M;i++)
        {
        p[i][0] = 1;
        for(int j=1;j<=i;j++)
        {
        p[i][j] = p[i-1][j]
        + p[i-1][j-1];
        if(p[i][j] > k)
        p[i][j] = k+1;
        }
}

        start : p[n+m][n];
        pos = n;
        for(i=n+m;i>=1;i--)
        {
        if(pos==0)
        //k번째 문자열이 a로 시작한다면
        if(p[i-1][pos-1] >= k)
        {
        sysout('a')
        pos--;
        }
        //k번째 문자열이 z로 시작한다면
        else
        {
        //k번째 문자열을 찾기 위해
        //z로 시작하는 k-(a로 시작하는 문자열 수) 번째 문자열 탐색
        sysout('z')
        k -= p[i-1][pos-1];
        }
        }```*/
