package sw;

import java.util.Scanner;

public class Solution15 {
    static int T;
    static long N,S,K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T=sc.nextInt();

        for(int t=1;t<=T;t++){
            S = sc.nextLong();
            K = S*S*2-1;
            N = K-(4*S)+4;
            System.out.println("#"+t+" "+N+" "+K);
        }
    }
}
