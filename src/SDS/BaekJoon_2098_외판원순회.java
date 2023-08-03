package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DP + 비트마스킹
 * DP[Cur][Visit] = Cur 도시까지 Visit 에 기록된 도시들을 방문하고 가는 최소 비용
 * n개의 도시 방문 기록 나타내기 -> 비트마스킹 이용 (배열보다 더 효율적)
 * ex) 4개의 도시 1,2,3,4 => 2와 3만 방문 -> 0110(2)=6
 */
public class BaekJoon_2098_외판원순회 {

    static int n;
    static int[][] w; // 비용
    static int[][] dp; // 도시 방문 후 드는 최소 비용
    static Integer visitAll;
    static final int INF = Integer.MAX_VALUE;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visitAll = (1<<n) -1; // n이 4일 때 => 10000(2) - 1 = 1111(2) = 15
        w= new int[n+1][n+1];
        dp= new int[n+1][visitAll+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 세팅
        answer = INF;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = INF;
            }
        }

        dp[1][1] = 0;
        getDP(1,1);

        System.out.println(answer);
    }

    static void getDP(int now, int visited) {
        // 모든 도시 방문했으면 최초 출발점으로 돌아가는 코드만 있으면 됨
        if (visited == visitAll) {
            if(w[now][1]==0){ // 현재 시점에서 출발점으로 갈 수 없는 경우
                return;
            }
            answer = Math.min(answer, dp[now][visited]+w[now][1]);
        }
        // 방문할 도시가 남았으면 1~n까지 모든 정점 탐색
        for(int i=1; i<=n; i++){
            int next = (1 << (i - 1));
            int nextVisited = next | visited;
            if (nextVisited == visited) {
                continue;
            }
            if(w[now][i] ==0){
                continue;
            }

            if (dp[i][nextVisited] > dp[now][visited]) {
                dp[i][nextVisited] = dp[now][visited];
                getDP(i, nextVisited);
            }
        }
    }
}
