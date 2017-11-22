
import java.util.*;

public class LengthEncoding {

	public static void main(String[] args) {
		System.out.println(encode("wwwwaaadexxxxxx"));
	}

	public static String encode(String source) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < source.length(); i++) {
			int runLength = 1;
			while(i < source.length()-1 && source.charAt(i) == source.charAt(i+1)) {
				runLength++;
				i++;
			}
			sb.append(source.charAt(i));
			sb.append(runLength);
		}


		return sb.toString();
	}

}