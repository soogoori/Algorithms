package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 단절점
 * dfs 이용
 *
 */
public class BaekJoon_11266_단절점 {

    static ArrayList<Integer>[] graph;
    static int v,e, order;
    static int[] searchOrder;
    static boolean [] isCutVertex;

    static int dfs(int now, boolean isRoot) {
        order++; // 방문순서
        searchOrder[now] = order;
        int rtn = order; // 지금 정점이후에 도달할 수 있는 모든 정점들의 탐색순서 중 가장 작은값
        int child = 0; // 자식의 숫자가 root일 경우 단절점 판단을 위함

        for (int next : graph[now]) {
            if (searchOrder[next] == 0) {
                child++;
                // 자식 정점 중 방문 순서가 가장 빠른 값.
                // 이때, 특정 자식 정점이 여러 개의 정점을 타고 타고 올라가서 1번 정점까지 갈 수도 있다는 점에 유의해야 함.
                int low = dfs(next, false);// 현재 정점의 다음에 방문할 모든 정점에 대해서 도달할수 있는 최소의 Order 순서 (우회로가 있나 찾아보는 것임)

                // Root 가 아니고, 내 다음에 방문할 정점의 순서가 모두 나보다 클 경우에 지금위치는 단절점이다.
                if (isRoot == false && low >= searchOrder[now]) {
                    isCutVertex[now] = true;
                }
                rtn = Math.min(rtn, low);
            } else { // 자식정점이 이미 방문한 경우
                rtn = Math.min(rtn, searchOrder[next]);
            }
        }

        // Root 의 경우 내 Order 보다 작은게 나올수 없기 때문에 자식노드의 숫자로 판단한다.
        if (isRoot == true && child >= 2) {
            isCutVertex[now] = true;
        }

        return rtn;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        for(int i=0; i<=v; i++){
            graph = new ArrayList[i];
        }

        for(int i=1; i<=v; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);

        }

    }
}
