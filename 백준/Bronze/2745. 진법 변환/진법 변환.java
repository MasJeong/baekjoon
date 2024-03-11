import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 진법 변환 - 수학
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = 0; i < n.length(); i++) {
            int square = n.length() - i - 1;

            // 문자
            if (n.charAt(i) > 57) {
                result += (int) (Math.pow(b, square) * (n.charAt(i) - 55));
            } else {
                result += (int) (Math.pow(b, square) * (n.charAt(i) - '0'));
            }
        }

        System.out.println(result);
        br.close();
    }

}
