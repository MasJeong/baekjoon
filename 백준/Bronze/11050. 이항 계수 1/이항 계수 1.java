import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이항 계수1 - 수학(조합론)
 */
public class Main {

    private static int fibonacci(int num) {
        if (num == 0) return 1;

        return num * fibonacci(num - 1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // nCr = n! / (n - r)! * r!
        System.out.println(fibonacci(n) / (fibonacci(n - k) * fibonacci(k)));
        br.close();
    }

}
