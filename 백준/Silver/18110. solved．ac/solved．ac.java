import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arrDifficulty = new int[n];

        for (int i = 0; i < n; i++) {
            arrDifficulty[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arrDifficulty);

        int avgCount = Math.round(n * ((float) 15 / 100));
        int sum = 0;

        for (int i = avgCount; i < arrDifficulty.length - avgCount; i++) {
            sum += arrDifficulty[i];
        }

        int result = Math.round((float) sum / (arrDifficulty.length - (avgCount * 2)));

        System.out.println(result);
        br.close();
    }
}
