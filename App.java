public class App{
    public static void main(String[] args){
        System.out.println("hello world");
       System.out.println(sum(20,10));
       System.out.println(loop(5));

    }

    private static int sum(int a, int b){
        int z = a+b;
        return z;
    }

    private static int loop(int x){
        int count =0;
        for(int i = 0; i<x; i++){
           // System.out.println(i);
            count = count+i;   //sum of the numbers..
            System.out.println("i: "+ i + ", count sum : "+ count);
        }
        return count;
    }
}

