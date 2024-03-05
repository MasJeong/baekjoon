import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ROT13
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 소문자
            if (ch >= 97 && ch <= 122) {
                for (int j = 0; j < 13; j++) {
                    if (ch + 1 == 123) {
                        ch = 97;
                    } else {
                        ch++;
                    }
                }
            }
            // 대문자
            else if (ch >= 65 && ch <= 90) {
                for (int j = 0; j < 13; j++) {
                    if (ch + 1 == 91) {
                        ch = 65;
                    } else {
                        ch++;
                    }
                }
            }

            sb.append(ch);
        }

        System.out.println(sb);

        br.close();
    }
}
