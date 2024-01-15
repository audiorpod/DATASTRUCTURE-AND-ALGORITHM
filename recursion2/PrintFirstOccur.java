package recursion2;
/*
 * f(arr,idx,x) ->> return first index of occur of x in the array [idx,n-1]
 * 
 * main->  f ( arr,0,x)
 * [0,n-1]
 * self work -> compare the element with x 
 */

public class PrintFirstOccur {

    
    private static int idx;
    public static int f(int[] arr, int idx, int x){
        // base case 
        if(idx == arr.length) return -1;
        return (arr[idx] == x) ? idx : f(arr,idx+1, x);

    }
    public static void main(String[] args) {
        int[] arr = { 31,22,12,-1,4,5,22,34,6,7,-4,0};
        int x = 22;
        System.out.println(f(arr, idx , x));
    }
    
}
