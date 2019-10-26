package Practice;


import java.util.Scanner;

public class P12048 {
    static int T, N;
    static String order;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        for (int tc =1 ;tc<=T;tc++){
            N = scanner.nextInt();
            order = scanner.nextLine();
            order= order.trim();

            int[][] arr = new int[N][N];
            boolean[][] collabo = new boolean[N][N];

            // INPUT
            for (int i=0;i<N ;i++){
                for (int j=0; j<N;j++){
                    int input = scanner.nextInt();
                    arr[i][j] = input;
                }
            }


            if (order.equals("left")) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] != 0) {
                            int ny = j;
                            int value = arr[i][j];
                            int move = j-1;
                            while (move >= 0) {
                             if(arr[i][move]==arr[i][ny]&&!collabo[i][move]){
                                  arr[i][move]*=2;
                                  arr[i][ny]=0;
                                  collabo[i][move]=true;
                                  break;
                              }else if(arr[i][move]!=0){
                                 break;
                             }
                             arr[i][ny] =0;
                             arr[i][move] = value;
                             ny = move;
                             move--;
                            }
                        }
                    }
                }
            }else if(order.equals("right")){
                for (int r = 0; r < N; r++) {
                    for (int c = N-1; c >= 0; c--) {
                        if (arr[r][c] != 0) {
                            int ry = c;
                            int value = arr[r][c];
                            int move = c+1;
                            while (move <N) {
                                if(arr[r][move]==arr[r][ry]&&!collabo[r][move]){
                                    arr[r][move]*=2;
                                    arr[r][ry]=0;
                                    collabo[r][move] = true;
                                    break;
                                }else if(arr[r][move]!=0){
                                    break;
                                }
                                arr[r][ry] =0;
                                arr[r][move] = value;
                                ry = move;
                                move++;
                            }
                        }
                    }
                }
            }else if(order.equals("up")){
                for (int r =0; r <N; r++) {
                    for (int c =0; c<N ; c++) {
                        if (arr[r][c] != 0) {
                            int nx = r;
                            int value = arr[r][c];
                            int move = r-1;
                            while (move >=0) {
                                if(arr[move][c]==arr[nx][c]&&!collabo[move][c]){
                                    arr[move][c]*=2;
                                    arr[nx][c]=0;
                                    collabo[move][c] = true;
                                    break;
                                }else if(arr[move][c]!=0){
                                    break;
                                }
                                arr[nx][c] =0;
                                arr[move][c] = value;
                                nx = move;
                                move--;
                            }
                        }
                    }
                }
            }else{
                for (int r =N-1; r >=0; r--) {
                    for (int c =0; c<N ; c++) {
                        if (arr[r][c] != 0) {
                            int nx = r;
                            int value = arr[r][c];
                            int move = r+1;
                            while (move <N) {
                                if(arr[move][c]==arr[nx][c]&&!collabo[move][c]){
                                    arr[move][c]*=2;
                                    arr[nx][c]=0;
                                    collabo[move][c]=true;
                                    break;
                                }else if(arr[move][c]!=0){
                                    break;
                                }
                                arr[nx][c] =0;
                                arr[move][c] = value;
                                nx = move;
                                move++;
                            }
                        }
                    }
                }
            }



            // RESULT
            System.out.println("#"+tc);
            for (int i=0;i<N ;i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
