package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_1991 {

    static int[][] child = new int[27][3];

    static void preOrder(int node){
        if (node==0) {
            return;
        }
        System.out.print((char)('A' +node-1));
        preOrder(child[node][0]);
        preOrder(child[node][1]);
    }

    static void inOrder(int node){
        if (node==0) {
            return;
        }
        inOrder(child[node][0]);
        System.out.print((char)('A' +node-1));
        inOrder(child[node][1]);

    }

    static void postOrder(int node){
        if (node==0) {
            return;
        }
        postOrder(child[node][0]);
        postOrder(child[node][1]);
        System.out.print((char)('A' +node-1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char a, b, c;

        for(int i=1; i<N; i++){
            String tmp = br.readLine();
            a = tmp.charAt(0);
            b = tmp.charAt(2);
            c = tmp.charAt(4);
            if (b != '.') {
                child[a - 'A'+1][0] = b - 'A'+1;
            }
            if(c!='.'){
                child[a-'A'+1][1] = c-'A'+1;
            }
        }
        for(int i =0; i<child.length; i++){
            for(int j=0; j<2; j++){
                System.out.println(child[i][j]);
            }
        }
        System.out.println();
        preOrder(1);
        System.out.println();
        inOrder(1);
        System.out.println();
        postOrder(1);
    }
}
