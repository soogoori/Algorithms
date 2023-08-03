package Programmers.Lv1;

import java.util.Stack;

public class Lv1_햄버거만들기 {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient));
    }

    public static int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stackIngredient = new Stack<>();

        for(int i=0; i<ingredient.length; i++){
            stackIngredient.push(ingredient[i]);

            if (stackIngredient.size()>=4 &&
                stackIngredient.get(stackIngredient.size()-4)==1 &&
                stackIngredient.get(stackIngredient.size()-3)==2 &&
                stackIngredient.get(stackIngredient.size()-2)==3 &&
                stackIngredient.get(stackIngredient.size()-1)==1) {

                answer++;
                stackIngredient.pop();
                stackIngredient.pop();
                stackIngredient.pop();
                stackIngredient.pop();

            }
        }

        return answer;
    }
}
