package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1103 {

    static int map[][];
    static int dist[][];
    static int visit[][];
    static int n,m;
    static int mx;
    static int xx,yy;
    static int dx[]= {0,1,0,-1};
    static int dy[]= {1,0,-1,0};
    static boolean isLoop;

    static void back(int x,int y, int cnt)
    {
        if(dist[x][y]>=cnt)return;
        dist[x][y] = cnt;
        if(mx < cnt)
            mx = cnt;

        visit[x][y] = 1;

        for(int i=0;i<4;i++)
        {
            xx = x+dx[i]*map[x][y];
            yy = y+dy[i]*map[x][y];
            if(xx<1||xx>n||yy<1||yy>m||map[xx][yy]==-1)continue;

            if(visit[xx][yy]==0)
            {
                back(xx,yy,cnt+1);
                if(isLoop)return;
            }
            else
            {
                isLoop = true;
                return;
            }
        }

        visit[x][y]=0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        dist = new int[n+1][m+1];
        visit = new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            String _tmp = br.readLine();
            for(int j=1;j<=m;j++)
            {
                if(_tmp.charAt(j-1)=='H')
                    map[i][j] = -1;
                else
                    map[i][j] = _tmp.charAt(j-1)-'0';
            }
        }

        back(1,1,1);

        if(isLoop) mx = -1;
        System.out.println(mx);
    }
}