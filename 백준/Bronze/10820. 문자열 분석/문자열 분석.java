import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 분석
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        while ((s = br.readLine()) != null) {
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                // 소문자
                if (ch >= 97 && ch <= 122) {
                    a++;
                }
                // 대문자
                else if (ch >= 65 && ch <= 90) {
                    b++;
                }
                // 숫자
                else if (ch >= 48 && ch <= 57) {
                    c++;
                } else {
                    d++;
                }
            }

            sb.append(a).append(" ").append(b).append(" ").append(c).append(" ").append(d).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
