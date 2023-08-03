package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BaekJoon_2243_사탕상자 {

    static int n;
    //사탕의 맛 : 1000000 2^20 = 1048576
    static int firstLeaf = 1048576;
    static int idx[] = new int[2100000];

    static void edit(int i, int diff)
    {
        int x = i + firstLeaf-1;
        while(x>0)
        {
            idx[x] += diff;
            x/=2;
        }
    }

    static int find(int a)
    {
        int x = 1;

        while(x<firstLeaf)
        {
            if(idx[x*2]>=a)
            {
                x = x*2;
            }
            else //if(idx[x*2]<a)
            {
                a -= idx[x*2];
                x = x*2+1;
            }
        }

        return x-firstLeaf + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i;
        int a,b,c;

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(i=1;i<=n;i++)
        {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());

            if(a==1) // 사탕 꺼내기
            {
                b = Integer.parseInt(st.nextToken());

                c = find(b);
                System.out.println(c);
                edit(c, -1);
            }
            else // 사탕 넣기
            {
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                edit(b, c);
            }
        }
    }
}