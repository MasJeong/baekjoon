import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 좌표 압축 - 정렬
 * 각 Xi 보다 작은 값들에 대한 갯수를 구하는 문제
 * 1) 내림차순 정렬
 * 2) 정렬을 안하고도 해보고 해서도 해보자
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] position = new int[n];
        int[] tempArr = new int[n];

        // 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            position[i] = Integer.parseInt(st.nextToken());
        }

        tempArr = position.clone();

        // 정렬
        Arrays.sort(tempArr);

        /*
            HashMap 검색속도 O(1)
            List 검색속도 O(n) - 정렬된 경우 이진탐색을 사용하여 O(log n)
         */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(tempArr[i])) {
                map.put(tempArr[i], cnt++);
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(map.get(position[i]))
                    .append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}
