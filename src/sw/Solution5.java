package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int t=1;t<=test;t++){


            int n = Integer.parseInt(br.readLine());

            String[][] ans = new String[n][3];

            String[][] arr = new String[n][n];
            String[][] copy = new String[n][n];

            for(int i=0;i<n;i++){
                String[] str = br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    arr[i][j] = str[j];
                }
            }

            int j=0;
            for(int i=0;i<3;i++){
                for(int r=0;r<n;r++){
                    for(int c=0;c<n;c++){
                        copy[c][n-1-r]=arr[r][c];
                    }
                }

                for(int r=0;r<n;r++){
                    String newch ="";
                    for(int c=0;c<n;c++){
                       newch+=copy[r][c];
                    }
                    ans[r][j]=newch;
                }
                j++;

                arr= copy.clone();

                copy=new String[n][n];
            }


            System.out.println("#"+t);
            for(int r=0;r<n;r++){
                for(int c=0;c<3;c++){
                    System.out.print(ans[r][c]+" ");
                }
                System.out.println();
            }
        }

    }
}
