import java.util.ArrayList;
public class BasicJava {
    public void print1to255(){
        for (int i=1;i<=255;i++)
            System.out.println(i);
    }
    public void print1to255odds(){
        for (int i=1;i<=255;i++)
            if(i%2==1)
                System.out.println(i);
    }
    public void print1to255sums(){
        int sum=0;
        for (int i=1;i<=255;i++){
            sum+=i;
            System.out.println("New number: "+String.valueOf(i)+" Sum: "+String.valueOf(sum));
        }
    }
    public void printArray(int [] arr){
        for(int i: arr){
            System.out.println(i);
        }
    }
    public int findMax(int [] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if (arr[i]>max)
                max=arr[i];
        }
        return max;
    }
    public double avg(int [] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return (double)sum/arr.length;
    }
    public Integer[] arrayOfOddsFrom1to255(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i=1;i<=255;i++){
            if(i%2==1)
                y.add(i);
        }
        return y.toArray(new Integer[0]);
    }

    public int greaterThanY(int[] arr, int y){
        int counter=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>y)
                counter++;
        }
        return counter;
    }
    public void square (int[]arr){
        for(int i=0;i<arr.length;i++){
            arr[i]*=arr[i];
        }
    }
    public void eliminateNegative(int[]arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0)
                arr[i]=0;
        }

    }
    public int[] min_max_avg(int[] arr){
        int max=arr[0],min=arr[0],sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min)
                min=arr[i];
            if(arr[i]>max)
                max=arr[i];
            sum+=arr[i];
        }
        int[] returnedArray={max,min,sum/arr.length};
        return returnedArray;

    }
    public void shiftLeft(int[] arr){
        for (int i=0;i+1<arr.length;i++){                
                arr[i]=arr[i+1];
        }
        arr[arr.length-1]=0;
    }
}
    