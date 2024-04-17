import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        final int NUMBER = 31;
        final int M = 1234567891;

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long sum = 0L;
        long pow = 1L;

        for (int i = 0; i < L; i++) {
            sum += (str.charAt(i) - 96) * pow;
            pow = (pow * NUMBER) % M;
        }

        sb.append(sum % M);

        System.out.println(sb);
        br.close();
    }

}
