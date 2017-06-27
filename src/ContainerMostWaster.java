import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Created by 短裤内穿的超人 on 2017/4/24.
 */
public class ContainerMostWaster {

    public static int Max(int[] h){
        int maxArea = 0;
        for(int i=0; i < h.length-1; i++){
            for (int j=i+1; j < h.length; j++){
                maxArea = max(maxArea,min(h[i],h[j])*(j-i));
            }
        }
        return maxArea;
    }

    public static int MaxArea(int[] h){
        int left = 0;
        int right = h.length-1;
        int maxArea = 0;
        while (left < right){
            maxArea = max(maxArea, min(h[left],h[right])*(right-left));
            if(h[left] < h[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int num = ContainerMostWaster.MaxArea(arr);
        System.out.println(num);

    }
}
