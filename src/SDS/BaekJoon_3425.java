package SDS;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BaekJoon_3425 {

    static int N = 0;
    static String op = "";

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<String> str = new ArrayList<>();

        do{
            op = sc.nextLine();
            str.add(op);
        }while(!(op.equals("END") || op.equals("QUIT")));

        for(String s : str){
            System.out.println(s);
        }

        N = sc.nextInt();

        int num1 = 0;
        int num2 = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            stack.push(sc.nextInt());
            for(int j=0; j<str.size(); j++){
                op = str.get(j).substring(0,2);

                switch (op){
                    case "NUM":
                        stack.push(Integer.parseInt(str.get(j).substring(4)));
                        break;
                    case "QUIT":
                        break;
                    case "POP" :
                        stack.pop();
                        break;
                    case "INV":
                        num1= stack.peek();
                        stack.pop();
                        stack.push((-1) * num1);
                        break;
                    case "DUP":
                        num1 = stack.peek();
                        stack.push(num1);
                        break;
                    case "SWP":
                        num1 = stack.peek();
                        stack.pop();
                        num2 = stack.peek();
                        stack.pop();
                        stack.push(num1);
                        stack.push(num2);
                        break;
                    case "ADD":
                        num1 = stack.peek();
                        stack.pop();
                        num2 = stack.peek();
                        stack.pop();
                        stack.push(num1 + num2);
                        break;
                    case "SUB":
                        num1 = stack.peek();
                        stack.pop();
                        num2 = stack.peek();
                        stack.pop();
                        stack.push(num2 - num1);
                        break;
                    case "MUL":
                        num1 = stack.peek();
                        stack.pop();
                        num2 = stack.peek();
                        stack.pop();
                        stack.push(num2*num1);
                        break;
                    case "DIV":
                        num1 = stack.peek();
                        stack.pop();
                        num2 = stack.peek();
                        stack.pop();
                        stack.push(num1/num2);
                        break;
                    case "MOD":
                        num1 = stack.peek();
                        stack.pop();
                        num2 = stack.peek();
                        stack.pop();
                        stack.push(num1%num2);
                        break;
                    case "END":
                        if(stack.size()==1){
                            System.out.println(stack.peek());
                            break;
                        }else{
                            System.out.println("Error");
                            break;
                        }
                }
            }
        }
    }
}
