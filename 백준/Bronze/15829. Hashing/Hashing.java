import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        final int NUMBER = 31;

        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();

        // 오버플로우 체크 필요
        long sum = 0L;

        for (int i = 0; i < str.length(); i++) {
            long a = str.charAt(i) - 96;

            sum += a * ((long) Math.pow(NUMBER, i));
        }

        sb.append(sum);

        System.out.println(sb);
        br.close();
    }

}
