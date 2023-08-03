package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {

    static int[] chonsu;
    static int n;
    static int cnt;

    static void union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);

        chonsu[yRoot] = xRoot;
    }

    static int find(int x){
        if(chonsu[x] == x){
            return x;
        }else{
            cnt++;
            System.out.println("cnt = " + cnt);
            return find(chonsu[x]);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        chonsu = new int[n + 1];

        for(int i=1; i<=m; i++){
            chonsu[i] = i;
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x,y);
        }

        cnt=0;
        if(find(a)==find(b)){
            System.out.println(cnt);
        }else{
            System.out.println(-1);
        }
    }
}
