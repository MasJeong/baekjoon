import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A + B - C
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        sb.append(Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c)).append("\n");
        sb.append(Integer.parseInt(a + b) - Integer.parseInt(c));

        System.out.println(sb);
        br.close();
    }

}
