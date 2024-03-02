import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 후위표기식2 - 자료구조
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        // 배열에 수 삽입
        double[] arrDouble = new double[n];
        for (int i = 0; i < arrDouble.length; i++) {
            arrDouble[i] = Double.parseDouble(br.readLine());
        }

        /*
         * 후위표기식
         * - 중위표기식을 연산자 순서에 따라 괄호로 묶고, 괄호안의 연산자를 괄호 뒤에 붙여준다.
         * (A + (B * C)) - (D / E)
         * ABC*+DE/-
         */
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // A ~ Z
            if (ch >= 65 && ch <= 90) {
                stack.push(arrDouble[ch - 'A']);
            } else {
                double result = 0.0;
                double a = stack.pop();
                double b = stack.pop();

                switch (ch) {
                    case '+':
                        result += b + a;
                        break;
                    case '*':
                        result += b * a;
                        break;
                    case '-':
                        result += b - a;
                        break;
                    case '/':
                        result += b / a;
                        break;
                }

                stack.push(result);
            }
        }

        System.out.printf("%.2f", stack.pop());
        br.close();
    }
}
