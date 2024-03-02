import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쇠막대기 - 자료구조
 * 이번엔 스택을 사용하지 않고 푼다.
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
         * ()(((()())(())()))(()) -> 17
         * (((()(()()))(())()))(()()) -> 24
         */
        String s = br.readLine();
        int answer = 0;
        int openCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openCount++;
                continue;
            }

            if (ch == ')') {
                openCount--;

                // isRazer true
                if (s.charAt(i - 1) == '(') {
                    answer += openCount;
                } else {
                    answer++;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
