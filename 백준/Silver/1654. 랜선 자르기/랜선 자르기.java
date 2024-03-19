import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 랜선 자르기 - 이분 탐색
 */
public class Main {

    private static long binarySearch(int[] arr, int n) {
        long left = 0L;
        // 가장 큰 수를 기준으로 이분탐색 진행
//        long right = arr[arr.length - 1];
        long right = Integer.MAX_VALUE;
        long result = 1L;

        /*
        left + right > 1 조건: mid가 0이 되면 안된다.
         */
        while (left <= right && left + right > 1) {
            // int의 경우 left와 right 둘 다 2^31-1인 경우 오버플로우가 발생한다.
            long mid = (left + right) >>> 1;
            int cntLine = 0;

            for (int i : arr) {
                cntLine += (int) (i / mid);
            }

            if (cntLine < n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                result = mid;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

//        Arrays.sort(arr);

        long answer = binarySearch(arr, n);

        System.out.println(answer);
        br.close();
    }

}