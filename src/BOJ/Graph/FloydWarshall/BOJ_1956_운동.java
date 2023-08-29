package BOJ.Graph.FloydWarshall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 사이클을 이루는 도로의 길이의 합이 최소가 되도록 하는 것 찾기
 * 최소 사이클의 도로 길이의 합 출력
 */
public class BOJ_1956_운동 {

    static int V, E;
    static int[][] dist;
    static int INF = 10000 * 400 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(i!=j){
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int result = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(i==j){
                    continue;
                }
                if (dist[i][j] != INF && dist[j][i] != INF) {
                    result = Math.min(result, dist[i][j] + dist[j][i]);
                }
            }
        }
        if (result == INF) {
            result =-1;
        }
        System.out.println(result);
    }
}