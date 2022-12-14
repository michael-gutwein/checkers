import java.util.Scanner;

class game{
    /**
     * Gets input of the coordinates from the user.
     * @return array of ints which contain the user input.
     */ 
    public static int[] getInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter start row(left side):");
        int startX = input.nextInt();
        System.out.println("Enter start column(top):");
        int startY = input.nextInt();
        System.out.println("Enter end row(left side):");
        int endX = input.nextInt();
        System.out.println("Enter end column(top):");
        int endY = input.nextInt();
        int[] inputArray = {startX, startY, endX, endY};
        return inputArray;
    }
    // input was not closed in the getInput() method because the program stopped working after.
    public static void main(String[] args) {
        board g = new board();
        Scanner input = new Scanner(System.in);
        g.printboard();
        while (true){
            System.out.println("Black Player's Turn");
            System.out.println("move(1) or jump(2)");
            int choice = input.nextInt();
            if (choice == 1){
                int[] array = getInput();
                if (g.board[array[0]][array[1]].getState() == "pawn"){
                    g.movePawnBlack(array[2], array[3], array[0], array[1]);
                }
                else{
                    g.moveKing(array[2], array[3], array[0], array[1]);
                }
                g.printboard();
            }
            else{
                System.out.println("Enter number of jumps:");
                int jumps = input.nextInt();
                int[] array = getInput();
                if (g.board[array[0]][array[1]].getState() == "pawn"){
                    g.jumpPawnBlack(array[2], array[3], array[0], array[1]);
                    g.printboard();
                    if (jumps > 1){
                        for (int i = 0; i < jumps - 1; i++){
                            int x = array[2];
                            int y = array[3];
                            array = getInput();
                            if (array[0] != x || array[1] != y){
                                System.out.println("Moving wrong piece.");
                            }
                            else{
                                g.jumpPawnBlack(array[2], array[3], array[0], array[1]);
                                g.printboard();
                            }
                        }
                    }
                }
                else{
                    g.jumpBlackKing(array[2], array[3], array[0], array[1]);
                    g.printboard();
                    if (jumps > 1){
                        for (int i = 0; i < jumps - 1; i++){
                            int x = array[2];
                            int y = array[3];
                            array = getInput();
                            if (array[0] != x || array[1] != y){
                                System.out.println("Moving wrong piece.");
                            }
                            else{
                                g.jumpBlackKing(array[2], array[3], array[0], array[1]);
                                g.printboard();
                            }
                        }
                    }
                }
            }
            int check = g.endGame();
            if (check == 1){
                System.out.println("Black Wins!");
                break;
            }
            System.out.println("White Players Turn");
            System.out.println("move(1) or jump(2)");
            choice = input.nextInt();
            if (choice == 1){
                int[] array = getInput();
                if (g.board[array[0]][array[1]].getState() == "pawn"){
                    g.movePawnWhite(array[2], array[3], array[0], array[1]);
                }
                else{
                    g.moveKing(array[2], array[3], array[0], array[1]);
                }
                g.printboard();
            }
            else{
                System.out.println("Enter number of jumps:");
                int jumps = input.nextInt();
                int[] array = getInput();
                if (g.board[array[0]][array[1]].getState() == "pawn"){
                    g.jumpPawnWhite(array[2], array[3], array[0], array[1]);
                    g.printboard();
                    if (jumps > 1){
                        for (int i = 0; i < jumps - 1; i++){
                            int x = array[2];
                            int y = array[3];
                            array = getInput();
                            if (array[0] != x || array[1] != y){
                                System.out.println("Moving wrong piece.");
                            }
                            else{
                                g.jumpPawnWhite(array[2], array[3], array[0], array[1]);
                                g.printboard();
                            }
                        }
                    }
                }
                else{
                    g.jumpWhiteKing(array[2], array[3], array[0], array[1]);
                    g.printboard();
                    if (jumps > 1){
                        for (int i = 0; i < jumps - 1; i++){
                            int x = array[2];
                            int y = array[3];
                            array = getInput();
                            if (array[0] != x || array[1] != y){
                                System.out.println("Moving wrong piece.");
                            }
                            else{
                                g.jumpWhiteKing(array[2], array[3], array[0], array[1]);
                                g.printboard();
                            }
                        }
                    }
                }
            }
            check = g.endGame();
            if (check == 2){
                System.out.println("White Wins!");
                break;
            }
    }
    input.close();
}
}
