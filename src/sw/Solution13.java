package sw;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution13 {
    static int T;
    static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        for(int t=1;t<=T;t++){
            int chair=0;
            N = scanner.nextInt();
            Integer[] arr = new Integer[N];

            for (int i=0;i<N;i++){
                arr[i]=scanner.nextInt();
            }

            Arrays.sort(arr, Collections.reverseOrder());
            for(int i=0;i<arr[0];i++){
                chair++;
            }

            for (int i=0;i<N;i++){
                chair++;
                for (int j=0;j<arr[i];j++){
                    chair++;
                }
            }

            System.out.println("#"+t+" "+chair);
        }

    }
}
