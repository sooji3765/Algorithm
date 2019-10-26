package sw;

import java.util.Scanner;

public class Calculator {
    static int T,N;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for(int t=1;t<=T;t++){
            int N = scanner.nextInt();
            int result = scanner.nextInt();

            for (int i=1;i<N;i++){
                int n = scanner.nextInt();
                result= result+n>result*n ?result+n: result*n;
            }

            System.out.println("#"+t+" "+result);
        }
    }
}
