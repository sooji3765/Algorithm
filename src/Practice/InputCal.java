package Practice;

import java.util.Scanner;

public class InputCal {
    static int N;
    static int[] nums;
    static int[] op;
    static char[] oper={'+','-','*','/'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        dfs(0);
    }

    public static void dfs(int index){
        if (index==N){

        }
    }
}
