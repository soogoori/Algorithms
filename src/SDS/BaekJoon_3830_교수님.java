package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * union-find 응용
 * A<->B B<->C A<->D 연결관계 존재시 A,B,C,D끼리 모두 비교 가능
 *
 */
public class BaekJoon_3830_교수님 {

    static int a,b,w;
    static String str;
    static int[] parent;
    static long[] weightDiff;
    static long answer;

    static void union(int a, int b, int diff) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB){
            return;
        }

        // 무게 차이를 부모 노드의 무게를 더해서 나타내기
        weightDiff[parentB] = weightDiff[a]-weightDiff[b] + diff;
        parent[parentB] = parentA;
    }

    static int find(int a) {
        if(parent[a] == a){
            return a;
        }else{
            int parentIdx = find(parent[a]);
            weightDiff[a] += weightDiff[parent[a]];
            return parent[a] = parentIdx;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n==0 && m==0){
                break;
            }

            weightDiff = new long[n+1];
            parent = new int[n + 1];

            for(int i=1; i<=n; i++){
                parent[i] = i;
            }

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                str = st.nextToken();
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if (str.equals("!")) {
                    w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                } else {
                    if (find(a) == find(b)) {
                        answer = weightDiff[b] - weightDiff[a];
                        bw.write(answer + "\n");
                    } else {
                        bw.write("UNKNOWN" + "\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
