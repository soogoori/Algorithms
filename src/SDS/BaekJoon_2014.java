package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon_2014 {

    static int n,m;
    static long data[] = new long[101];
    static PriorityQueue<Long> q = new PriorityQueue<>();

    public static void main(String args[]) throws IOException
    {
        int i,j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(i=1;i<=n;i++)
        {
            data[i] = Long.parseLong(st.nextToken());
            q.offer(data[i]);
        }

        long c=0;
        for(i=1;i<=m;i++)
        {
            long d = q.poll();

            //중복제거
            while(c==d)
            {
                d = q.poll();
            }
            c = d;

            for(j=1;j<=n;j++)
            {
                if(data[j]*c<=2147483647)//int max
                    q.offer(data[j]*c);
                if(c%data[j]==0)break;
            }
        }

        System.out.println(c);
    }
}