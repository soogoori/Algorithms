package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Inversion Counting
 * 세그먼트 트리
 * 정렬 + 이진탐색 or hash
 */
public class BaekJoon_7578_공장 {
    static int n;
    static int[] A;
    static int[] tree;
    static int TreeSize, Offset;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        A = new int[n + 1];

        getTreeSize();

        tree = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> B = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int val = Integer.parseInt(st.nextToken());
            B.put(val, i);
        }

        long answer = 0;

        for (int i = 1; i <= n; i++) {
            // A 배열 i 기계가 B 배열로 바뀔 위치 찾기 -> 완전탐색은 시간초과 -> 해시나 정렬+이진탐색 이용
            int idxB = B.get(A[i]);

            // 바뀔 위치의 tree에 +1 -> update
            update(idxB, 1);

            // valB보다 큰 인덱스 중에 이미 방문한 적이 있는 인덱스의 개수 구하기
            // (바뀔 위치+1) ~ n까지 구간 합 구해서 정답 갱신
            answer +=getSum(idxB+1, n);

        }
    }

    public static void getTreeSize() {
        TreeSize = 1;
        while (TreeSize < n) {
            TreeSize = TreeSize * 2;
        }
        TreeSize = TreeSize * 2;
    }

    // 바뀔 위치의 tree 값 업데이트
    static void update(int index, int val){
    }

    // 구간 합 구하기
    static long getSum(int left, int right){

        return 0;
    }
}
