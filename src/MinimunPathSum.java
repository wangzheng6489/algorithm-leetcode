import java.util.Scanner;

import static java.lang.Math.min;

/**
 * Created by 短裤内穿的超人 on 2017/4/10.
 * leetcode: ac
 * title: MinimunPathSum
 * olution: 二维动态规划求解，注意矩阵第一列和第一行
 */
public class MinimunPathSum{
    public static int MinPathSum(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int i,j;
        int[][] dp = new int [m][n];
        dp[0][0] = arr[0][0];
        for(i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        for(j=1;j<n;j++){
            dp[0][j] = dp[0][j-1] + arr[0][j];
        }
        for(i=1;i<m;i++){
           for(j=1;j<n;j++){
               dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + arr[i][j];
           }
        }
        return  dp[m-1][n-1];
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        /*
        对输入的二维数组进行存储
         */
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int num = MinimunPathSum.MinPathSum(arr);
        System.out.println(num);
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

}
