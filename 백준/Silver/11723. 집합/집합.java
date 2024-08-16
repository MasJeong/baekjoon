import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        final int SET_SIZE = 20;

        int m = Integer.parseInt(br.readLine());
        Map<Integer, Integer> S = new HashMap<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();

            int x = 0;
            if(!oper.equals("empty") && !oper.equals("all")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (oper) {
                case "add":
                    if (!S.containsKey(x)) {
                        S.put(x, x);
                    }
                    break;
                case "remove":
                    S.remove(x);
                    break;
                case "check":
                    if (S.containsKey(x)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }

//                    System.out.println(x + "\n");
                    sb.append("\n");
                    break;
                case "toggle":
                    if (S.containsKey(x)) {
                        S.remove(x);
                    } else {
                        S.put(x, x);
                    }
                    break;
                case "all":
                    S.clear();

                    // 1 ~ 20 삽입
                    for (int i = 0; i < SET_SIZE; i++) {
                        S.put(i + 1, i + 1);
                    }
                    break;
                case "empty":
                    S.clear();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + oper);
            }
        }

        System.out.println(sb);
        br.close();
    }

}