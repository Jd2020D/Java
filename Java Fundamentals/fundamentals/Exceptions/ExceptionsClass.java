import java.util.ArrayList;
public class ExceptionsClass {
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("Succssess : index of " + i+" with value of "+myList.get(i) + " has casted to Integer");
            }catch(ClassCastException e){
                    System.out.println(e);
            }
        }
        
    }
}