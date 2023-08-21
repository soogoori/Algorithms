package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS -> 세가지 방식으로 뻗어나가기 때문에 너비우선탐색으로 .. !
 */
public class BOJ_1697_숨바꼭질 {

    static int n,k;
    static int[] move = {-1, 1, 2};
    static int[] moveCnt= new int[100001];

    static void findBro(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        moveCnt[start]=1;


        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == k) {
                System.out.println(moveCnt[now]-1);
                return;
            }
            for (int i = 0; i < move.length; i++) {
                int next;

                if (i == 2) {
                    next = now*move[i];
                }else{
                    next = now+move[i];
                }

                if(next>=0 && next<=100000 && moveCnt[next]==0){
                    queue.add(next);
                    moveCnt[next] = moveCnt[now]+1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        findBro(n);
    }
}
