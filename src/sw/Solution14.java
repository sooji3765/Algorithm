package sw;

import java.util.Scanner;

public class Solution14 {
    static int T,N,B,E;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T=sc.nextInt();

        for(int t=1;t<=T;t++){
            int cnt=0;
            N = sc.nextInt();
            B = sc.nextInt();
            E = sc.nextInt();

            for(int i=0;i<N;i++){
                int watch = sc.nextInt();
                int r =1;

                while (true){
                    int time = watch*r;
                    if(time<B-E)
                        r++;
                    else if(time>B+E)
                        break;
                    else{
                        cnt++;
                        break;
                    }
                }
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
}
