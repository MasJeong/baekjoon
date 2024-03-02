import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		// 1개씩 뽑아내서 배열에 저장 - > 배열 정렬 후 출력
		String[] arr = new String[str.length()];

		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.substring(i, str.length());
		}

		Arrays.sort(arr);

		for (int i = 0; i < str.length(); i++) {
			bw.write(arr[i] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}