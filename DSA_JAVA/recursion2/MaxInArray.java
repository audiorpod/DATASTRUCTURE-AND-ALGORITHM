package recursion2;

public class MaxInArray {

    private static int idx;
    public static  int f(int[] arr, int idx ){
        // base case 
        if( idx == arr.length -1) return arr[idx]; // if u ra at the  last index, it is your a 
        return Math.max(arr[idx], f(arr, idx+1));
    }
    public static void main(String[] args) {
        int[] arr = {31,22,12,-1,4,5,12,22,34,6,7,-4,0};
        
        System.out.println(f(arr, idx));
    }
    
}
