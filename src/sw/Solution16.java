package sw;

import java.util.Scanner;

public class Solution16 {
    static int T,N;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        for(int t=1;t<=T;t++){

            N = scanner.nextInt();
            int[] arr = new int[N];
            int[] dp = new int[N];

            for(int i=0;i<N;i++)
                arr[i]= scanner.nextInt();

            dp[0] = arr[0];
            int max = arr[0];

            for(int i=1;i<N;i++){
                dp[i] = Math.max(arr[i],dp[i-1]+arr[i]);
                max = Math.max(max,dp[i]);
            }

            System.out.println("#"+t+" "+max);
        }
    }
}
