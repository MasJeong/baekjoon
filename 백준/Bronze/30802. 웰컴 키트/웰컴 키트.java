import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 웰컴 키트
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        final int SHIRT_SIZE = 6;
        int[] arrShirt = new int[SHIRT_SIZE];

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < SHIRT_SIZE; i++) {
            arrShirt[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int cntT = 0;

        for (int i = 0; i < arrShirt.length; i++) {
            int bundle = arrShirt[i];

            if(bundle == 0) continue;

            int div = bundle / t;

            /*
            1. 몫이 0이고 나머지가 없는 경우 + 1
            2. 몫이 0이고 나머지가 있는 경우 + 1
            3. 몫이 0이 아니고 나머지가 있는 경우 div + 1
            4. 몫이 0이 아니고 나머지가 없는 경우 div
             */
            if (div == 0) {
                cntT++;
            } else {
                cntT += bundle % t == 0 ? div : div + 1;
            }
        }

        sb.append(cntT).append("\n");
        sb.append(n / p).append(" ").append(n % p);

        System.out.println(sb);
        br.close();
    }

}
