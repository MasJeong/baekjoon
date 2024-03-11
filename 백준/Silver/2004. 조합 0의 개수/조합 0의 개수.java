import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 조합 0의 개수 - 수학 (조합) TODO 소인수분해
 * nCr = n! / (n-r)! * r!    n은 최대 갯수, r은 뽑는 숫자 갯수
 * 조합값을 소인수분해했을 때 포함되어있는 2와 5의 개수를 찾는다.
 * 아래는 2와 5의 개수를 찾는 이유.
 * ex) 2^7 * 5^3 = 2^3 * 5^3 * 2^4
 * = (2 * 5)^3 * 2^4
 * = 10^3 * 2^4
 * = 1000 * 16
 * = 16000
 * <p>
 * 조합 공식을 아래와 같이 정의할 수 있다.
 * n! = 2^a1 * 5^a2
 * (n-r)! = 2^b1 * 5^b2
 * r! = 2^c1 * 5^c2
 * => 2^a1 - 2^b1 - 2^c1 * 5^a2 - 5^b2 - 5^c2
 */
public class Main {

    private static int getCount(int a, int k) {
        int count = 0;

        while (a >= k) {
            count += a / k;
            a /= k;
        }

        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a = getCount(n, 2) - getCount(n - m, 2) - getCount(m, 2);
        int b = getCount(n, 5) - getCount(n - m, 5) - getCount(m, 5);

        int result = Math.min(a, b);

        System.out.println(result);
    }

}
