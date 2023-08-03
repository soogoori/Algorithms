package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2042_구간합구하기 {

    static int a,b,c;
    static int N, M, K;
    static int firstLeaf;
    static long[] data;
    static long[] tree = new long[2100000];

    static void update(int idx, int chg){
        // leaf 노드로 이동
        int x = firstLeaf + idx -1;

        // leaf 수정 후 부모로 이동
        tree[x] = chg; // 수정
        x/=2; // 부모로 이동
        while(x>=1){
            tree[x] = tree[x * 2 + 1] + tree[x * 2];// 자식 노드 2개 덧셈
            x/=2;
        }
    }

    static long partialSum(int x, int l, int r, int search_l, int search_r){ //top-down
        // x=현재 내 위치
        // search_ = 찾고자 하는 범위
        if(search_r < l || r<search_l){
            return 0;
        }
        if(search_l <= l && search_r >=r){
            return tree[x];
        }

        return partialSum(x*2, l, (l+r)/2, search_l, search_r)
                + partialSum(x*2+1, (l+r)/2, r, search_l, search_r);

    }

    static long partialSum(int l, int r){ // bottom-up
        // leaf 노드로 이동
        l = firstLeaf+l-1;
        r = firstLeaf+r-1;

        long sum=0;

        while(l<=r){// left와 right 가 크로스될 때까지 진행
            // left 가 오른쪽 노드이면 더해주고 범위 좁히기
            if(l%2==1)  sum+=tree[l++];
            // right 가 왼쪽 노드이면 더해주고 범위 좁히기
            if(r%2==0) sum += tree[r++];

            // 부모로 이동
            l/=2;
            r/=2;
        }
        //System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new long[N+1];

        for(int i=1; i<data.length; i++){
            data[i] = Long.parseLong(br.readLine());
        }

        // 시작 노드 계산
        firstLeaf = 1;
        while(firstLeaf<N){
            firstLeaf*=2;
        }

        // 트리에 데이터 입력
        for(int i=1; i<=N; i++){
            tree[firstLeaf + i - 1]= data[i];
        }
        for(int i=firstLeaf-1; i>=1; i--){
            tree[i] = tree[i*2] + tree[i*2-+1];
        }

        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a==1){
                update(b, c);
            }else if(a==2){
                System.out.println(partialSum(b, c));
            }
        }
    }
}
