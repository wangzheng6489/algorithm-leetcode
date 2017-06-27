import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by 短裤内穿的超人 on 2017/4/16.
 * leetcode:ac
 * title: MaximumSubarray
 * solution: 一维动态规划求解，局部最优和全局最优法，由局部最优推全局最优。i表示包含第i个元素的局部最大子数组是什么
 *           我们只需维护2个变量，一个是局部最大，一个是全局最大
 * /----*****************************----/
 * title: Maximum Product Subbarray
 * solution: 一维动态规划求解，最大子数组乘积,局部最优和全局最优法,这里对于局部变量我们需要维护其2个变量，一个是局部最大，一个是全局最大，
 *          因为每一个第i元素的局部最大最小都由3种情况构成，一种是i-1元素的最大*当前元素i，一种是i-1元素的最小*当前元素，一种是当前元素
 *          也就是我们只需判断这3种情况下，取最大最小就行
 */
public class MaxiumSubarray {

    /*------最大子数组之和------*/
    public static int MaxSubarray(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int[] local = new int[arr.length];
        int[] global = new int[arr.length];
        local[0] = arr[0];
        global[0] = arr[0];
        for(int i=1; i < arr.length; i++){
            local[i] = max(arr[i], arr[i]+local[i-1]);
            global[i] = max(global[i-1], local[i]);
        }
        return global[arr.length-1];
    }

    /*------最大子数组乘积------*/
    public static int MaxProductSubarray(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int max_local[] = new int[arr.length];
        int min_local[] = new int[arr.length];
        int[] global = new int[arr.length];
        max_local[0] = arr[0];
        min_local[0] = arr[0];
        global[0] = arr[0];
        for(int i=1; i < arr.length; i++){
            max_local[i] = max(max(arr[i] * max_local[i-1], arr[i]), arr[i] * min_local[i-1]);
            min_local[i] = min(min(arr[i] * max_local[i-1], arr[i]), arr[i] * min_local[i-1]);
            global[i] = max(global[i-1], max_local[i]);
        }
        return global[arr.length-1];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int sum = MaxiumSubarray.MaxProductSubarray(arr);

        System.out.println(sum);

//        for(int i=0;i<n;i++){
//            System.out.print(arr[i]+" ");
//        }
    }
}
