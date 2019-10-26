package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution7 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int t=1;t<=test;t++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            int cnt=1;
            int bottom = -1;
            int top=1;
            int right=0;
            int input =n;

            for(int i=input;i>=0;i--){
                for(int j=0;j<input;j++){
                    bottom+=top;
                    arr[right][bottom] =cnt++;
                }
                input--;
                for(int j=0; j<input;j++){
                    right+=top;
                    arr[right][bottom] =cnt++;
                }

                top*=-1;
            }

            System.out.println("#"+t);
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(arr[i][j] + "\t");

                }
                System.out.println("");
            }


        }

    }
}
