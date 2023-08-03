package SDS;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon_7578_공장_sol {
    static int N;
    static int [] A;
    static HashMap<Integer, Integer> B;
    static int[] Tree ;
    static int TreeSize, Offset;
    static long Answer; // Tree 및 Answer 의 경우 Integer 의 범위를 넘을수 있음을 고려하자.

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int [N + 1];
        B = new HashMap<>(); // key - 식별번호, value - 인덱스
        Answer = 0;

        getTreeSize(); // Tree Size 구하기
        Offset = (TreeSize >> 1) - 1; // Tree의 Offset 구하기
        Tree = new int [TreeSize];

        // 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            B.put(Integer.parseInt(st.nextToken()), i);
        }

        int index;
        for(int i = 1 ; i <= N ; i++) {
            index = B.get(A[i]);
            Answer += getSum(index+1, N);
            updateTree(index, 1);
        }

        bw.write(Answer + "\n");
        bw.flush();
        bw.close();
    }

    private static void updateTree(int index, int value) {
        // index : 업데이트 위치, value : 업데이트 될 값
        index = index + Offset;
        Tree[index] += value;
        // 부모를 찾기위해 절반으로 나누면서 Root 까지 올라간다.
        for (index >>= 1; index != 0; index >>= 1) {
            Tree[index] = Tree[index * 2] + Tree[index * 2 + 1];
        }
    }

    private static long getSum(int left, int right) {
        long sum = 0;
        left += Offset; // tree 배열의 인덱스로 변환
        right += Offset; // tree 배열의 인덱스로 변환

        while (left <= right) {
            if (left % 2 == 1) { // Left 가 홀수이면 ( 즉 left 가 오른쪽 자식이면 )
                sum += Tree[left]; // 바꾸고 한칸 오른쪽으로
                left++;
            }
            if (right % 2 == 0) { // Right 가 짝수이면 ( 즉 right 가 왼쪽 자식이면 )
                sum += Tree[right]; // 바꾸고 한칸 왼쪽으로
                right--;
            }
            left >>= 1;   // left = left / 2; 와 동일함.
            right >>= 1;  // right = right / 2; 와 동일함.
        }
        return sum;
    }

    public static void getTreeSize() {
        TreeSize = 1;
        while (TreeSize < N) {
            TreeSize = TreeSize * 2;
        }
        TreeSize = TreeSize * 2;
    }
}
