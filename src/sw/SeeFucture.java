package sw;

import java.util.Scanner;

public class SeeFucture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int i=1;i<=t;i++){
           int n = scanner.nextInt();
           int[] arr = new int[n];

           for(int j=0;j<arr.length;j++)
               arr[j] = scanner.nextInt();

           int ans=0, max = arr[n-1];

           for(int j=0;j<n;j++){
               if(max >=arr[j])
                   ans+=max-arr[j];
               else
                   max=arr[j];
           }

           System.out.printf("#%d %d",t, ans);

        }
    }
}
