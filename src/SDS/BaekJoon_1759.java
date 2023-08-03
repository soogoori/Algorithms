package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_1759{

    static int n, m;
    static String cs[];
    static List<String> answers = new ArrayList<>();

    static void back(int x,int prev, String key)
    {
        if(x==n+1)
        {
            char _t;
            int cnt = 0;
            for(int i=0;i<n;i++)
            {
                _t = key.charAt(i);
                if(_t == 'a' || _t == 'e' || _t == 'i' || _t == 'o' || _t == 'u')
                    cnt++;
            }

            if(cnt >= 1 && n-cnt >= 2)
                answers.add(key);
            return;
        }

        for(int i=prev+1;i<m;i++)
        {
            back(x+1,i,key+cs[i]);
        }
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cs = new String[m];
        for(int i=0;i<m;i++)
        {
            cs[i] = st.nextToken();
        }
        Arrays.sort(cs);

        back(1,-1,"");

        for(String key : answers)
        {
            System.out.println(key);
        }
    }
}