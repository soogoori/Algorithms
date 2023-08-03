package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 스택 풀이
 *
 * 1. 시작점과 끝점을 찾음
 * 2. N개의 배열 생성해서 L 위치에 높이값 넣어줌
 */
public class BOJ_2304_창고다각형 {

    static int N;
    static int[] storages;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        storages = new int[1001];
        int start = Integer.MAX_VALUE;
        int end =0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            storages[L] = H;
            start = Math.min(start, L);
            end = Math.max(end, L);
        }

        Stack<Integer> stack = new Stack<>();

        // 왼쪽 비교
        int temp = storages[start];
        for (int i = start+1; i <= end; i++) {
            if (storages[i] < temp) {
                stack.add(i);
            } else {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    storages[x]=temp;
                }
                temp = storages[i];
            }
        }
        stack.clear();

        // 오른쪽 비교
        temp = storages[end];
        for (int i = end - 1; i >= start; i--) {
            if (storages[i] < temp) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    storages[x] = temp;
                }
                temp = storages[i];
            }
        }

        int area=0;
        for (int i = start; i <= end; i++) {
            area += storages[i];
        }
        System.out.println("area = " + area);
    }
}
