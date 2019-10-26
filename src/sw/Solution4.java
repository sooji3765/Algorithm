package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(bufferedReader.readLine());

        for(int i=1;i<=test;i++){
            boolean correct =true;

            int[][] arr = new int[9][9];

            for(int j=0;j<9;j++){
                String[] str = bufferedReader.readLine().split(" ");
                int k=0;
                for(String s : str){
                    arr[j][k++]=Integer.parseInt(s);
                }
            }

            for(int j=0;j<9;j++){
                int r=0,c=0,p=0;
                //세로,가로
                for(int k=0;k<9;k++) {
                    r += arr[k][j];
                    c += arr[j][k];
                }

                //구역
                // j%3 = 0 0,1,2
                // j%3= 1 -> 3,4,5
                // j%3=2 -> 6,7,8
                // 0 (0,0)-(2,2) :  1 (0,3)-(2,5) : 2 (0,6),(2,8)
                // 3 (3,0)-(3,2) :  4             5
                // 6 (6,0)- (6,2):  7             8

                for(int k=0;k<3 ;k++){
                    int a = 0;
                    if(j%3==0)
                        a=0;
                    else if(j%3==1)
                        a=3;
                    else
                        a=6;
                    for(int e=0;e<3;e++){
                        p+=arr[(j/3)*3+e][a+k];
                    }

                }

                if(r!=c||r!=p||c!=p){
                    correct=false;
                    break;
                }

            }

            System.out.printf("#%d %d",i,correct==true?1:0);

        }
    }
}
