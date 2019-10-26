package Practice;

import java.util.Scanner;

public class P11 {
    static int N, L;
    static int[][] map;
    static boolean[] made;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();

        map= new int[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int re = solve();

        System.out.println(re);
    }
    public static int solve(){
        int cnt =0;

        int c =0;
        while (c<N){
            // 행, 열 맵
            int[] arr1 = new int[N];
            int[] arr2 = new int[N];

            for (int i =0;i<N;i++){
                arr1[i] = map[c][i];
            }
            for (int i =0;i<N;i++){
                arr2[i] = map[i][c];
            }

            cnt+=check(arr1)+check(arr2);
            c++;
        }

        return cnt;
    }

    public static int check(int[] arr){

        int i =0;
        made = new boolean[N];
        while (i<N-1){
            int dis = Math.abs(arr[i]-arr[i+1]);
            if (dis>1) return 0;
            if (dis==0) i++;

            // 높이 차이가 1일때
            if (dis==1) {
                if (arr[i] > arr[i + 1]) {
                    if (count(i + 1, i + L, arr[i + 1], arr)) i += L;
                    else return 0;
                } else {
                    if (count(i - L + 1, i, arr[i], arr)) i += 1;
                    else return 0;
                }
            }
        }
        return 1;
    }
    static boolean count(int start, int end, int ans, int[] arr){
        if (start<0||end>=N) return false;
        for (int i= start;i<=end;i++) {
            if (made[i]) return false;
            made[i] = true;
            if (arr[i] != ans)
                return false;
        }
        return true;
    }
}
