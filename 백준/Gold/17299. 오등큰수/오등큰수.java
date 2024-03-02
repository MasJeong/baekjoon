import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 오등큰수 - 자료구조
 */
public class Main {

    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        final int COUNTING_MAX_SIZE = 1000001;

        int n = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        // 원본배열
        int[] arrOriginal = new int[n];
        // 카운팅 배열
        int[] arrCounting = new int[COUNTING_MAX_SIZE];
        // 결과 배열
        int[] answer = new int[n];

        /*
         * 1 1 2 3 4 2 1 - 원본
         * 3 3 2 1 1 2 3 - 카운팅
         * -1 -1 1 2 2 1 -1
         */
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            // 원본 배열 세팅
            arrOriginal[i] = input;

            // 카운팅 배열 세팅
            arrCounting[arrOriginal[i]]++;
        }

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arrCounting[arrOriginal[stack.peek()]] < arrCounting[arrOriginal[i]]) {
                answer[stack.pop()] = arrOriginal[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        for (int i = 0; i < n - 1; i++) {
            sb.append(answer[i]).append(" ");
        }
        sb.append(answer[n - 1]);

        System.out.println(sb);
        br.close();
    }
}
