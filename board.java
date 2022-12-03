class board{
    pieces[][] board;
    
    public board(){
        board = new pieces[8][8];
        initialization(); 
    }
    


    public boolean commonValidation(int newX, int newY, int oldX, int oldY){
        if ((oldY + 1 != newY && oldY - 1 != newY) || board[newX][newY] != null || newX < 0 || newX > 7 || newY < 0 || newY > 7){
            return false;
        }
        return true;
    }
    // Reminder: Check state and colour in game.java, remove from methods
    public void movePawnWhite(int newX, int newY, int oldX, int oldY){
        if (oldX - 1 != newX || board[oldX][oldY].colour != "white" || board[oldX][oldY].state != "pawn" || commonValidation(newX, newY, oldX, oldY) == false){
            System.out.println("Invalid move!");
        }
        else{
            pieces temp = new pieces(board[oldX][oldY]);
            board[oldX][oldY] = board[newX][newY];
            board[newX][newY] = temp;
        }    
    }

    public void movePawnBlack(int newX, int newY, int oldX, int oldY){
        if (oldX + 1 != newX || board[oldX][oldY].colour != "black" || board[oldX][oldY].state != "pawn" || commonValidation(newX, newY, oldX, oldY) == false){
            System.out.println("Invalid move!");
        }
        else{
            pieces temp = new pieces(board[oldX][oldY]);
            board[oldX][oldY] = board[newX][newY];
            board[newX][newY] = temp;
        }    
    }

    public void initialization(){
        for (int i = 1; i < 8; i += 2){
            board[0][i] = new pieces(0, i, "black", "pawn");
            board[2][i] = new pieces(2, i, "black", "pawn");
            board[6][i] = new pieces(6, i, "white", "pawn");
            board[1][i] = new pieces(1, i, "red", "pawn");
            board[3][i] = new pieces(3, i, "red", "pawn");
            board[4][i] = new pieces(4, i, "red", "pawn");
            board[5][i] = new pieces(5, i, "red", "pawn");
            board[7][i] = new pieces(7, i, "red", "pawn");
        }
        for (int i = 0; i < 8; i += 2){
            board[1][i] = new pieces(1, i, "black", "pawn");
            board[5][i] = new pieces(5, i, "white", "pawn");
            board[7][i] = new pieces(7, i, "white", "pawn");
            board[0][i] = new pieces(0, i, "red", "pawn");
            board[2][i] = new pieces(2, i, "red", "pawn");
            board[3][i] = new pieces(3, i, "red", "pawn");
            board[4][i] = new pieces(4, i, "red", "pawn");
            board[6][i] = new pieces(6, i, "red", "pawn");
        }
        
        
    }

    public void printboard(){
        System.out.println("----------------------------------");
        for (int i = 0; i < 8; i++){
            System.out.print(" | ");
        for (int j = 0; j < 8; j++){
            if (board[i][j] == null){
                System.out.print(" " + " | ");
            }
            else{
                System.out.print(board[i][j] + " | ");
            }
        }
        System.out.println();
        System.out.println("----------------------------------");
    }
        System.out.println("   A    B    C    D    E    F    G    H");
 
    }
 
}

