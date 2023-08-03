package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon_14003_가장긴증가하는부분5 {

    static int binarySearch(int[] array, int key, int from, int to) {
        int low = from;
        int high= to;

        while (low <= high) {
            int mid = (low+high)/2;
            if (array[mid] > key) {
                high=mid-1;
            }else if(array[mid]<key) {
                low = mid+1;
            }else{
                return mid;
            }
        }
        return low;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 1];
        int[] d = new int[n+1];
        int[] from = new int[n+1];
        int[] tracking = new int[n + 1];

        int length=0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        length++;
        d[1] = num[1];
        from[1] = 1;

        for(int i=2; i<=n; i++){
            int searchIndex = binarySearch(d, num[i], 1, length); // 정해진 길이에서만 이진탐색
            from[i] = searchIndex;
            if (searchIndex > length) {
                length++;
                d[length] = num[i]; // d 배열 끄트머리에 추가
            }else{
                d[searchIndex] = num[i]; // d 배열에 있던 요소를 대체
            }
        }
        int answer = 0;

        answer = length;

        // LIS의 길이에서 내려오면서 실제 LIS 를 찾기
        for(int i=n; i>=1; i--){
            if (length == from[i]) {
                tracking[length] = num[i];
                length--;
            }
        }

        bw.write(answer + "\n");
        for (int i = 1; i <= answer; i++) {
            bw.write(tracking[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
