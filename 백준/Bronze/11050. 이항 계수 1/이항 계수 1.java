import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이항 계수1 - 수학(조합론)
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int a = 1;
        int b = 1;
        int c = 1;

        for (int i = 2; i <= n; i++) a *= i;
        for (int i = 2; i <= n - k; i++) b *= i;
        for (int i = 2; i <= k; i++) c *= i;

        System.out.println(a / (b * c));
        br.close();
    }

}
