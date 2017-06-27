
/**
 * Created by 短裤内穿的超人 on 2017/3/14.
 * 编程之美：未完善
 * title：象棋将帅问题
 * solution：位进制解决问题
 */
public class ChessProblem {
    final static int HALF_BITS_LENGTH = 4;
    final static int FULLMASK = 255;
    final static int LMASK = FULLMASK << HALF_BITS_LENGTH; //1111 0000
    final static int RMASK = FULLMASK >> HALF_BITS_LENGTH;//0000 1111

    public final static int RSET(int b, int n){ //设置低四位为n,保持高四位不变
        b = (b & LMASK) | n;
        return b;
    }
    public final static int LSET(int b, int n){ //设置高四位为n,保持低四位不变
        b = (b & RMASK) | (n << HALF_BITS_LENGTH);
        return b;
    }
    public final static int RGET(int b){ //设置低四位为n,保持高四位不变
        b = (b & RMASK);
        return b;
    }
    public final static int LGET(int b){ //设置低四位为n,保持高四位不变
        b = (b & LMASK) >> HALF_BITS_LENGTH;
        return b;
    }

    public static void main(String[] args){
        int b = 1;
        for(LSET(b,1); LGET(b) <= 9; LSET(b,(LGET(b)+1))){
            for(RSET(b,1); RGET(b) <= 9; RSET(b,(RGET(b)+1))){
                if(LGET(b) % 3 != RGET(b) % 3){
                    System.out.println("A="+LGET(b)+" B="+RGET(b));
                }
            }
        }

    }


}
