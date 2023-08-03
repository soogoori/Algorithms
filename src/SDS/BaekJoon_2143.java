package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_2143 {

    // 각 배열의 모든 부분집합 구한 후 부분집합의 합을 subA, subB에 저장 후 정렬
    static int[] A;
    static int[] subA;
    static int[] B;
    static int[] subB;
    static int T, n, m;

    static int[] sub(int[] a, int[] sub){
        int j = 0;
        int k=0;
        int l=0;
        int len = sub.length;
        int n = a.length;

        for(j=0; j<n; j++){
            k=j;
            int sum=0;
            while(k<n && l<len){
                sum+=a[k++];
                sub[l++] = sum;
            }
        }
        Arrays.sort(sub);
        for (int i : sub) {
            System.out.println("i = " + i);
        }
        return sub;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        B = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        /*int j = 0;
        int k=0;
        int l=0;
        subA = new int[(1 + n) * n / 2];
        subB = new int[(1 + m) * m / 2];

        for(j=0; j<n; j++){
            k=j;
            int sum=0;
            while(k<n && l<subA.length){
                sum+=A[k++];
                subA[l++] = sum;
            }
        }*/

        subA = new int[(1 + n) * n / 2];
        subB = new int[(1 + m) * m / 2];

        subA=sub(A, subA);
        subB=sub(B, subB);


        // subA와 subB 배열 거꾸로 비교해서 T 값 갖는지 확인

        int sum=0;
        int j=0;
        int k=subB.length-1;
        long cnt=0;

        while(k>=0 && j<subA.length){
            int a = subA[j];
            int b= subB[k];
            sum = a+b;
            if(sum==T){
                int cntA=0;
                int cntB=0;

                while(j<subA.length && subA[j]==a){
                    cntA++;
                    j++;
                }
                while(k>=0 && subB[k]==b){
                    cntB++;
                    k--;
                }
                cnt += cntA*cntB;
            }else if(sum>T){
                k--;
            }else if(sum<T){
                j++;
            }
        }

        System.out.println(cnt);
    }
}
