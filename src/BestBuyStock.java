import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by 短裤内穿的超人 on 2017/5/9.
 * leetcode:ac
 * title: Best Time to Buy and Sell Stock系列
 * solution: 动态规划求解
 */
public class BestBuyStock {
    //leetcode 121
    public static int BestBuyStock1(int[] p){
        if(p == null || p.length == 0){
            return 0;
        }
        int low = p[0];
        int ans = 0;
        for(int i=0; i < p.length-1; i++){
            if(p[i] < low){low = p[i];}
            if(p[i] - low > ans){ans = p[i] -low;}
        }
        return ans;
    }

    //leetcode 122
    public static int BestBuyStock2(int[] p){
        int diff = 0;
        int res = 0;
        for(int i=0; i < p.length-1; i++){
            diff = p[i+1] - p[i];
            if(diff > 0){
                res = res + diff;
            }

        }
        return res;
    }

    //leetcode 123
    public static int BestBuyStock3(int[] p){
        if(p.length == 0 || p == null){
            return 0;
        }
        int low = p[0]; int ans = 0; int res = 0; int n = p.length; int high = p[n-1];
        int opt[] = new int[n];
        int optReverse[] = new int[n];
        int tmp = 0;
        //顺序遍历找到最大利润，也就p[0.....i]间的利润
        for(int i=1; i < n; i++){
            if(p[i] < low){low = p[i]; opt[i] = 0;}
            if(p[i] - low > ans){ans = p[i] -low;}
            opt[i] = ans;

        }
        //逆序遍历找到最大利润，也就p[i....n-1]间的利润
        for(int i=n-2; i >= 0; i--){
            if(p[i] > high){high = p[i];}
            if(high - p[i] > res){res = high - p[i];}
            optReverse[i] = res;
        }
        for(int i = 0; i < n; i++){
            tmp = opt[i] + optReverse[i];
            if(ans < tmp){ans = tmp;}  //判断一次交易和交易两次的利润谁大
        }
        return ans;
    }

    //leetcode 188
    public static int BestBuyStock4(int k, int[] p){
        if(p.length == 0 || p == null || k <= 0){
            return 0;
        }
        int diff = 0;
        int n = p.length;
        int [][] local = new int[n][k+1];
        int [][] global = new  int[n][k+1];
        for(int i=0;i<=k;i++ ){
            global[0][i] = 0;
            local[0][i] = 0;
        }
        for(int i = 1;i < n; i++){
            diff = p[i] - p[i-1];
            for (int j = 1; j <= k; j++){
                local[i][j] = max((global[i-1][j-1]+max(diff,0)),local[i-1][j]+diff);
                global[i][j] = max(global[i-1][j],local[i][j]);
            }
        }

        return global[n-1][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
//        int num = BestBuyStock.BestBuyStock3(arr);
//        System.out.println(num);
        int num = BestBuyStock.BestBuyStock4(k,arr);
        System.out.println(num);

    }
}
