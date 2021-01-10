public class BasicJavaTesting {
    public static void print_arr(int[] arr){
        String s="[";
        for(int i:arr)
            s+=String.valueOf(i)+" , ";
        s+="]";
        System.out.println(s);
    }
    public static void print_arr(Integer[] arr){
        String s="[";
        for(Integer i:arr)
            s+=String.valueOf(i)+" , ";
        s+="]";
        System.out.println(s);

    }

    public static void main(String[] args) {
        BasicJava test= new BasicJava();
        System.out.println("print1to255");
        test.print1to255();
        System.out.println("print1to255odds");
        test.print1to255odds();
        System.out.println("print1to255sums");
        test.print1to255sums();
        int[] arr={1,2,3,4};
        System.out.println("printArray({1,2,3,4})");
        test.printArray(arr);
        int[] arr2={-1,-4,5,0,1,4,4};
        System.out.println("test.findMax({-1,-4,5,0,1,4,4})");
        System.out.println(test.findMax(arr2));
        System.out.println("test.avg({1,2,3,4})");
        System.out.println(test.avg(arr));
        System.out.println("test.arrayOfOddsFrom1to255()");
        print_arr(test.arrayOfOddsFrom1to255());
        System.out.println("test.greaterThanY({1,2,3,4}, 1)");
        System.out.println(test.greaterThanY(arr, 1));
        System.out.println("test.square({1,2,3,4})");
        test.square(arr);
        print_arr(arr);
        System.out.println("test.eliminateNegative({1,2,3,4})");
        test.eliminateNegative(arr);
        print_arr(arr);
        System.out.println("test.min_max_avg({1,2,3,4})");
        print_arr(test.min_max_avg(arr));
        System.out.println("test.shiftLeft({1,2,3,4})");
        test.shiftLeft(arr);
        print_arr(arr);
    }
}
