package SDS;

import java.util.Scanner;

public class BaekJoon_1644
{
    static int n,cnt;
    static int P[] = new int[4000001];
    static int Plist[] = new int[1000001],Pcnt,l,r,sum;

    public static void main(String[] args) throws Exception {

        int i,j;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(i=2;i<=n;i++)
        {
            if(P[i]==0)
            {
                Plist[++Pcnt] = i;
                for(j=i+i;j<=n;j+=i)
                {
                    P[j]=1;
                }
            }
        }

        l=r=1;sum = Plist[1];
        while(r<=Pcnt)
        {
            if(sum >= n)
            {
                if(sum==n)
                {
                    cnt++;
                }
                sum-=Plist[l];
                l++;
            }
            else if(sum < n)
            {
                r++;
                sum+=Plist[r];
            }
        }

        System.out.println(cnt);

        sc.close();
    }
}