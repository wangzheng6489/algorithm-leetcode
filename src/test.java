/**
 * Created by 短裤内穿的超人 on 2017/5/22.
 */
public class test {
    public static void main(String[] args) {
        int i,j,temp=0;
        int a[] = {5,1,2,3,6,4,9};
        for( i=0; i<6; i++){
            for( j=i+1; j<6; j++){
                if(a[i] > a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            for(int t=0; t<7;t++) {
                System.out.print(a[t] + " ");
            }
            System.out.println();

        }
        for(int t=0; t<7;t++) {
            System.out.print(a[t] + " ");
        }
    }
}
