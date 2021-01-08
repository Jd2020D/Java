package ss;

public class aaa {
	
	public static String generateX(int n) {
		String b="";
		for (int i = 0; i < n; i++) {
			b+="x";
		}
		return b;
	}
	public static String replaceX(String original,String badword) {
		int index=original.toLowerCase().indexOf(badword);
		if(index>=0) {
			original=original.substring(0,index)+generateX(badword.length())+original.substring(index+badword.length(),original.length());
		}
		return original;
	}
	
	public static String filter(String original) {
		String []  badWords = {"crack", "poop"};
		String [] words=original.split(" ");
		for (int i = 0; i < badWords.length; i++) {
			for (int j = 0; j < words.length; j++) {
				words[j]=replaceX(words[j], badWords[i]);
			}
		}
		original="";
		for (String word : words) {
			original+=word+" ";
		}
		return original;
	}

	public static void main(String[] args) {
		String s="Snap crackle pop nincompoop!";
		System.out.println(filter(s));
	}

}
