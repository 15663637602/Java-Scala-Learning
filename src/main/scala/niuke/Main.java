package niuke;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int row = Integer.parseInt(s[0].split(",")[0]);
            int col = Integer.parseInt(s[0].split(",")[0]);
            char[][] board = new char[row+1][col+1];
            for (int i=0;i<board.length;i++) {
                for (int j =0; j<board[i].length;j++){
                    board[i][j] = '1';
                }
            }
            int s_row = Integer.parseInt(s[1].split(",")[0]);
            int s_col = Integer.parseInt(s[1].split(",")[1]);
            board[s_row][s_col] = 'S';
            int e_row = Integer.parseInt(s[2].split(",")[0]);
            int e_col = Integer.parseInt(s[2].split(",")[1]);
            board[e_row][e_col] = 'E';
            int bad = Integer.parseInt(s[3]);
            for(int i=4;i<4+bad;i++){
                int b_row = Integer.parseInt(s[i].split(",")[0]);
                int b_col = Integer.parseInt(s[i].split(",")[1]);
                board[b_row][b_col] = 'X';
            }
            shortestPath(board);
        }
    }


    public static void shortestPath(char[][] matrix) {
        int s_row = 0, s_col = 0;
        boolean flag = false;
        for (s_row = 0; s_row < matrix.length; s_row++) {
            for (s_col = 0; s_col < matrix[0].length; s_col++) {
                if (matrix[s_row][s_col] == 'S')
                    flag = true;
                if (flag)
                    break;
            }
            if (flag)
                break;
        }
         shortestPath(matrix, s_row, s_col);
    }

    public static void shortestPath(char[][] matrix, int s_row, int s_col) {
        Queue<int[]> nextToVisit = new LinkedList<>();
        int[] n = {s_row, s_col};
        nextToVisit.offer(n);
        Set<String> visited = new HashSet<>();
        Queue<int[]> temp = new LinkedList<>();
        Stack<String> sk = new Stack<>();

        ArrayList<Object[]> l = new ArrayList<>();

        while (!nextToVisit.isEmpty()) {
            boolean b = true;
            int[] position = nextToVisit.poll();
            int row = position[0];
            int col = position[1];
            sk.push("["+row+","+col+"]");

            if (matrix[row][col] == 'E'){
                Object[] ar = sk.toArray();
                l.add(ar);
            }
            if (row > 0 && !visited.contains((row - 1)+":"+col) && matrix[row - 1][col] != 'X'){
                b = false;
                temp.offer(new int[] {row - 1, col});
            }

            if (row < matrix.length - 1 && !visited.contains((row + 1)+":" +col)
                    && matrix[row + 1][col] != 'X'){
                b = false;
                temp.offer(new int[] {row + 1, col});
            }

            if (col > 0 && !visited.contains(row +":"+(col - 1)) && matrix[row][col - 1] != 'X'){
                b = false;
                temp.offer(new int[] {row, col - 1});
            }

            if (col < matrix[0].length - 1 && !visited.contains(row+":" +(col + 1))
                    && matrix[row][col + 1] != 'X'){
                b = false;
                temp.offer(new int[] {row, col + 1});
            }
            if (b) {
                sk.pop();
            }
            if (nextToVisit.isEmpty() && !temp.isEmpty()) {
                visited.add(row+":"+col);
                nextToVisit = temp;
                temp = new LinkedList<>();
            }

        }
        if (l.size() == 0) {
            System.out.println("no way out");
        } else {
            for (Object[] o : l) {

            }
            for(Object s : l.get(0)) {
                System.out.print(s.toString());
            }
        }

    }

}