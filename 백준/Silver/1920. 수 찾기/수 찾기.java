import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수 찾기 - 이진 탐색
 */
public class Main {

    private static int[] arrSearch;

    private static int binarySearch(int num) {
        int left = 0;
        int right = arrSearch.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (arrSearch[mid] > num) {
                right = mid - 1;
            } else if (arrSearch[mid] < num) {
                left = mid + 1;
            } else {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 입력 시작
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arrSearch = new int[n];

        for (int i = 0; i < n; i++) {
            arrSearch[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        // 입력의 끝

        // 이분탐색 전 정렬
        Arrays.sort(arrSearch);

        // 이분탐색
        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(b[i])).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}
