package rotate;

public class rotate {

	public static boolean isRotation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		String temp = str2;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.equals(temp))
				return true;
			temp = temp.charAt(str2.length() - 1) + temp.substring(0, str2.length() - 1);
		}
		return false;
	}

	public static boolean isRotation2(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		// ABCDABCD --> CDAB
		String temp = str1 + str1;
		if (temp.indexOf(str2) < 0)
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isRotation("ABCD", "CDAB"));
		System.out.println(isRotation2("dia", "adi"));

	}

}
