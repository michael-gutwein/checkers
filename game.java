import java.util.Scanner;

class game{

    public static void main(String[] args) {
        board g = new board();
        Scanner input = new Scanner(System.in);
        g.printboard();
        while (true){
            System.out.println("BLACK PAWN METHOD");
            int startX = input.nextInt();
            int startY = input.nextInt();
            int endX = input.nextInt();
            int endY = input.nextInt();
            g.movePawnBlack(endX, endY, startX, startY);
            g.printboard();
            System.out.println("WHITE PAWN METHOD");
            startX = input.nextInt();
            startY = input.nextInt();
            endX = input.nextInt();
            endY = input.nextInt();
            g.movePawnWhite(endX, endY, startX, startY);
            g.printboard();
        }

        // for (int i = 0; i < g.board.length; i ++){
        //     for (int j = 0; j < g.board.length; j ++){
        //         System.out.println(i + "," + j + ": " + g.board[i][j]);
        //     }
        // }
    }
}
// g.moveWhite(4, 1, 5, 2);
// g.moveWhite(4, 3, 5, 2);
// g.moveWhite(4, 0, 5, 2);
// g.moveWhite(4, 4, 5, 2);
// g.moveWhite(3, 1, 5, 2);
// g.moveWhite(0, 1, 5, 2);
// g.moveWhite(4, 2, 5, 2);
// g.moveWhite(5, 1, 5, 2);
// g.moveWhite(3, 0, 2, 1);
