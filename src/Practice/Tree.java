package Practice;

import java.util.*;

public class Tree {
    static int N, M, K;
    static int[][] arr;
    static int[][] eat;
    static class Node{
        int x, y, z;
        boolean alive;
        public Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
            alive = true;
        }

    }

    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static LinkedList<Node> trees = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N][N];
        eat = new int[N][N];



        for (int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = 5;
                eat[i][j] = sc.nextInt();
            }
        }

            for (int i = 0; i < M; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();
                trees.add(new Node(x - 1, y - 1, z));
            }

            int years = 0;

        while(years<K){
            // 봄

            for (Node trees: trees){
                if (arr[trees.x][trees.y]>=trees.z){
                    arr[trees.x][trees.y]-=trees.z;
                    trees.z++;
                }else{
                    trees.alive = false;
                }
            }

            //여름
            Iterator it = trees.iterator();
            while (it.hasNext()){
                Node tree = (Node)it.next();
                if (!tree.alive){
                    arr[tree.x][tree.y]+=tree.z/2;
                    it.remove();
                }
            }


            //가을
            LinkedList<Node> newTree = new LinkedList<>();
            for (Node tree: trees){
                if (tree.z%5==0) {
                    for (int i = 0; i < 8; i++) {
                        int nx = tree.x + dx[i];
                        int ny = tree.y + dy[i];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            newTree.add(new Node(nx, ny, 1));
                        }
                    }
                }
            }

            trees.addAll(0,newTree);


            //겨울
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    arr[i][j]+=eat[i][j];
                }
            }

            years++;
        }

        System.out.println(trees.size());
    }
}
