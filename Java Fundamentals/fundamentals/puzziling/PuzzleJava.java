import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {

	public static Integer[] task1(int[] arr){
		int sum=0;
		ArrayList<Integer> biggerThan10=new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			if (arr[i]>10)
			biggerThan10.add(arr[i]);
		}
		System.out.println(sum);
		return biggerThan10.toArray(new Integer[0]);

	}
	public static void ShuffleArray(String[] arr){
		Random r= new Random();
		for (int i = 0; i < arr.length/2; i++) {
			String temp=arr[i];
			int index=r.nextInt(arr.length-i)+i;
			arr[i]=arr[index];
			arr[index]=temp;
		}	
	} 
	public static void ShuffleArray(char[] arr){
		Random r= new Random();
		for (int i = 0; i < arr.length/2; i++) {
			char temp=arr[i];
			int index=r.nextInt(arr.length-i)+i;
			arr[i]=arr[index];
			arr[index]=temp;
		}	
	} 
	public static String[] task2(String[] names){
		ArrayList<String> namesHasMoreThan5=new ArrayList<String>();
		ShuffleArray(names);
		for (String name : names) {
			System.out.println(name);
			if (name.length()>5)
				namesHasMoreThan5.add(name);
		}
		return namesHasMoreThan5.toArray(new String[0]);
	}
	public static void task3(char[] alphabet){
		ShuffleArray(alphabet);
		System.out.println("last letter "+alphabet[alphabet.length-1]);
		System.out.println("first letter "+alphabet[0]);
		if(alphabet[0]=='o' ||alphabet[0]=='a'||alphabet[0]=='e'||alphabet[0]=='i'||alphabet[0]=='u' )
			System.out.println(alphabet[0]+"  is vowel!");
	}
	public static int[] task4(){
		Random r=new Random();
		int[] retturendArray=new int[10];
		for (int i = 0; i < retturendArray.length; i++) {
			retturendArray[i]=r.nextInt(101-55)+55;
		}
		return retturendArray;
	}
	public static Integer[] task5	(){
		Random r=new Random();
		ArrayList<Integer> retturendArray= new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			retturendArray.add(r.nextInt(101-55)+55);
		}
		Collections.sort(retturendArray);
		System.out.println(retturendArray.get(0)+" is min");
		System.out.println(retturendArray.get(9)+" is max");
		return retturendArray.toArray(new Integer[0]);
	}
	public static String task6(){
		Random r=new Random();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		String randomString="";
		for (int i = 0; i < 5; i++) {
			randomString+=alphabet[r.nextInt(alphabet.length-1)];
		}
		return randomString;
	}
	public static String[] task7(){
		String[] randomStrings=new String[10];
		for (int i = 0; i < 10; i++) {
			randomStrings[i]=task6();
		}
		return randomStrings;
	}
	public static void main(String[] args) {
		int[] arr1={3,5,1,2,7,9,8,13,25,32};
		Integer[] arr1_result = task1(arr1);
		String[] names={"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
		String[] namesHasMoreThan5Chars=task2(names);
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		task3(alphabet);
		int[] numsBetween55and100=task4();
		String randomString= task6();
		String[] randomStrings= task7();
		
			

	}

}
