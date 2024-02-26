import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
 * 에디터 - 자료구조
 */
public class Main {
    private static final LinkedList<Character> linkedList= new LinkedList<>();

    private static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 처음 입력받은 문자열 push
        for (int i = 0; i < n.length(); i++) {
            linkedList.add(n.charAt(i));
        }

        idx = linkedList.size();

        ListIterator<Character> listIterator = linkedList.listIterator();

        while (listIterator.hasNext()) {
            listIterator.next();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            switch (cmd) {
                case 'L':
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                    break;
                case 'D':
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                    break;
                case 'B':
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                    break;
                case 'P':
                    listIterator.add(st.nextToken().charAt(0));
                    break;
            }
        }

        linkedList.forEach(sb::append);

        System.out.println(sb);
        br.close();
    }
}
