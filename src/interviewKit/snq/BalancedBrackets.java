package interviewKit.snq;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for(char c : chars){

            if(c == '(' || c == '[' || c == '{' ){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    stack.push(c);
                }
                char curr = stack.peek();
                if(c == ')' && curr == '('||
                        c == ']' && curr == '[' ||
                        c == '}' && curr == '{'){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }

        if(stack.isEmpty()) return "YES";
        else return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }


        scanner.close();
    }
}
