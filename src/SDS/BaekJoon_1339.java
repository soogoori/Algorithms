package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_1339{

    static int n;
    static String[] strs;
    static int visit[] = new int[26];
    static int check[] = new int[11];
    static int visit_n[] = new int[10];
    static int mx;

    static int stoi(int x)
    {
        int _t=0;

        for(char c : strs[x].toCharArray())
        {
            _t*=10;
            _t+=check[visit[c-'A']];
        }

        return _t;
    }

    static void back(int x)
    {
        if(x==11)
        {
            int sum = 0;
            for(int i=0;i<n;i++)
            {
                sum+=stoi(i);
            }
            if(sum>mx)
                mx=sum;
            return;
        }

        for(int i=0;i<10;i++)
        {
            if(visit_n[i]==0)
            {
                visit_n[i] = 1;
                check[x] = i;
                back(x+1);
                visit_n[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        strs = new String[n];

        for(int i=0;i<n;i++)
        {
            strs[i] = br.readLine();
            for(char a : strs[i].toCharArray())
            {
                visit[a-'A']=1;
            }
        }
        for(int i=1;i<26;i++)
            visit[i]+=visit[i-1];

        back(1);

        System.out.println(mx);
    }
}