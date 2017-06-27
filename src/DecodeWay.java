import java.util.Scanner;

/**
 * Created by 短裤内穿的超人 on 2017/3/30.
 * leetcode:ac
 * title: DecodeWay
 * solution: 一维动态规划求解，注意各个条件
 */
public class DecodeWay {

    public static int DecodeNum(String str){
        if(str == null || str.length() == 0 || str.charAt(0) == '0'){
            return 0;
        }
        int dp[] = new int[str.length()+1];
        dp[0] = 1;                              //统一初始化为1
        dp[1] = 1;                              //第一个字符所能够组成的编码个数为1
        for(int i=2;i<=str.length();i++){
            if(str.charAt(i-1) == '0' ){
                if(str.charAt(i-2) == '1' || str.charAt(i-2) == '2'){
                    dp[i]=dp[i-2];
                }
                if(str.charAt(i-2) == '0'){
                    return 0;
                }
            }else{
                if(str.charAt(i-2) == '0' || str.charAt(i-2) >=  '3'){
                    dp[i] = dp[i-1];
                }else {
                    if(str.charAt(i-2) == '2' && str.charAt(i-1) >= '7'){
                        dp[i] = dp[i-1];
                    }else{
                        dp[i] = dp[i-1]+dp[i-2];
                    }
                }
            }
        }

        return dp[str.length()];

    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
//        System.out.println(str);
        int num = DecodeNum(str);
        System.out.println(num);

    }
}
