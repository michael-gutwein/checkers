class board{
    pieces[][] board;
    int whiteCounter = 12;
    int blackCounter = 12;


    /**
     * Constructor for board
     */
    public board(){
        board = new pieces[8][8];
        initialization(); 
    }
    

    /**
     * @return int which represents the value of the player. 1 will represent black win. 
     * 2 will represent white win.
     */
    public int endGame(){
        if (whiteCounter <= 0){
            return 1;
        }
        else if (blackCounter <= 0){
            return 2;
        }
        return 0;
    }
    
    /**
     * Jump method for the black king. Killing method
     * @param newX End coordinate of the piece (row/x)
     * @param newY End coordinate of the piece (column/y)
     * @param oldX Start coordinate of the piece (row/x)
     * @param oldY Start coordinate of the piece (column/y)
     */
    public void jumpBlackKing(int newX, int newY, int oldX, int oldY){
        boolean checkeroo = true;
        if ((oldX - 2 != newX && oldX + 2 != newX)){
            System.out.println("You're moving too far up or down.");
        }
        if (commonValidation(newX, newY, oldX, oldY) == false){
            checkeroo = false;
        }
        if (checkeroo == true){
            int checkY = newY - oldY;
            int checkX = newX - oldX;
            if (checkY == 2 && checkX == -2){
                if (board[oldX - 1][oldY + 1].getColour() == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY + 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else if (checkY == 2 && checkX == 2) {
                if (board[oldX + 1][oldY + 1].getColour() == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY + 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else if (checkY == -2 && checkX == -2){
                if (board[oldX - 1][oldY - 1].getColour() == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY - 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else if (checkY == -2 && checkX == 2){
                if (board[oldX + 1][oldY - 1].getColour() == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY - 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else{
                System.out.println("You're going too far across.");
            }
        }
    }

    /**
     * Jump method for the white king. Killing method
     * @param newX End coordinate of the piece (row/x)
     * @param newY End coordinate of the piece (column/y)
     * @param oldX Start coordinate of the piece (row/x)
     * @param oldY Start coordinate of the piece (column/y)
     */
    public void jumpWhiteKing(int newX, int newY, int oldX, int oldY){
        boolean checkeroo = true;
        if ((oldX - 2 != newX && oldX + 2 != newX)){
            System.out.println("You're moving too far up or down.");
        }
        if (commonValidation(newX, newY, oldX, oldY) == false){
            checkeroo = false;
        }
        if (checkeroo == true){
            int checkY = newY - oldY;
            int checkX = newX - oldX;
            if (checkY == 2 && checkX == -2){
                if (board[oldX - 1][oldY + 1].getColour() == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY + 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else if (checkY == 2 && checkX == 2) {
                if (board[oldX + 1][oldY + 1].getColour() == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY + 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else if (checkY == -2 && checkX == -2){
                if (board[oldX - 1][oldY - 1].getColour() == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY - 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else if (checkY == -2 && checkX == 2){
                if (board[oldX + 1][oldY - 1].getColour() == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY - 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else{
                System.out.println("You're going too far across."); 
            }
        }
    }

    /**
     * move method for the king piece. Applys to both black and white pieces since 
     * both can move in all directions
     * @param newX End coordinate of the piece (row/x)
     * @param newY End coordinate of the piece (column/y)
     * @param oldX Start coordinate of the piece (row/x)
     * @param oldY Start coordinate of the piece (column/y)
     */
    public void moveKing(int newX, int newY, int oldX, int oldY){
        boolean checkeroo = true;
        if ((oldY + 1 != newY && oldY - 1 != newY)){
            System.out.println("You're moving too far across.");
            checkeroo = false;
        }
        if ((oldX + 1 != newX && oldX - 1 != newX)){
            System.out.println("You've gone too far up or down.");
            checkeroo = false;
        }
        if (board[oldX][oldY].getState() != "king"){
            System.out.println("You're moving a pawn.");
            checkeroo = false;
        }
        if (commonValidation(newX, newY, oldX, oldY) == false){
            checkeroo = false;
        }
        if (checkeroo == true){
            swap(newX, newY, oldX, oldY);
        }    
    }


    /**
     * swap method which swaps the piece killed to null and sets the piece that killed to 
     * the location of where the piece that got killed was.
     * @param newX End coordinate of the piece (row/x)
     * @param newY End coordinate of the piece (column/y)
     * @param oldX Start coordinate of the piece (row/x)
     * @param oldY Start coordinate of the piece (column/y)
     */
    public void swap(int newX, int newY, int oldX, int oldY){
        pieces temp = new pieces(board[oldX][oldY]);
        board[oldX][oldY] = board[newX][newY];
        board[newX][newY] = temp;
    }

    /**
     * Jump method for the white pawn. Killing method
     * @param newX End coordinate of the piece (row/x)
     * @param newY End coordinate of the piece (column/y)
     * @param oldX Start coordinate of the piece (row/x)
     * @param oldY Start coordinate of the piece (column/y)
     */
    public void jumpPawnWhite(int newX, int newY, int oldX, int oldY){
        boolean checkeroo = true;
        if (oldX - 2 != newX){
            System.out.println("You're moving too far up.");
            checkeroo = false;
        }
        if (commonValidation(newX, newY, oldX, oldY) == false){
            checkeroo = false;
        }
        if (checkeroo == true){
            int check = newY - oldY;
            if (check == 2){
                if (board[oldX - 1][oldY + 1].getColour() == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY + 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else if (check == -2){
                if (board[oldX - 1][oldY - 1].getColour() == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY - 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else{
                System.out.println("You're going too far across.");
            }
        }
        
    }

    /**
     * Jump method for the black pawn. Killing method
     * @param newX End coordinate of the piece (row/x)
     * @param newY End coordinate of the piece (column/y)
     * @param oldX Start coordinate of the piece (row/x)
     * @param oldY Start coordinate of the piece (column/y)
     */
    public void jumpPawnBlack(int newX, int newY, int oldX, int oldY){
        boolean checkeroo = true;
        if (oldX + 2 != newX){
            System.out.println("You're moving too far down.");
            checkeroo = false;
        }
        if (commonValidation(newX, newY, oldX, oldY) == false){
            checkeroo = false;
        }
        if (checkeroo = true){
            int check = newY - oldY;
            if (check == 2){
                if (board[oldX + 1][oldY + 1].getColour() == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY + 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else if (check == -2){
                if (board[oldX + 1][oldY - 1].getColour() == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY - 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("You're not jumping over the right piece.");
                }
            }
            else{
                System.out.println("You're going too far across.");
            }
        }
        
    }

    /**
     * common validation between all the methods.
     * @param newX End coordinate of the piece (row/x)
     * @param newY End coordinate of the piece (column/y)
     * @param oldX Start coordinate of the piece (row/x)
     * @param oldY Start coordinate of the piece (column/y)
     * @return true or false. true means it is valid. false means it isn't
     */
    public boolean commonValidation(int newX, int newY, int oldX, int oldY){
        if (board[newX][newY] != null){
            System.out.println("There is a piece there.");
            return false;
        }
        if (newX < 0){
            System.out.println("You've gone out of bounds.");
            return false;
        }
        if (newX > 7){
            System.out.println("You've gone out of bounds.");
            return false;
        }
        if (newY < 0){
            System.out.println("You've gone out of bounds.");
            return false;
        }
        if (newY > 7){
            System.out.println("You've gone out of bounds.");
            return false;
        }
        return true;
    }

    /**
     * move method for white pawn. can only go up.
     * @param newX End coordinate of the piece (row/x)
     * @param newY End coordinate of the piece (column/y)
     * @param oldX Start coordinate of the piece (row/x)
     * @param oldY Start coordinate of the piece (column/y)
     */
    public void movePawnWhite(int newX, int newY, int oldX, int oldY){
        boolean checkeroo = true;
        if ((oldY + 1 != newY && oldY - 1 != newY)){
            System.out.println("You're moving too far across");
            checkeroo = false;
        }
        if (oldX - 1 != newX) {
            System.out.println("You're moving too far up"); 
            checkeroo = false;
        }
        if (board[oldX][oldY].getColour() != "white"){
            System.out.println("You're moving the other player's piece");
            checkeroo = false;
        }
        if (board[oldX][oldY].getState() != "pawn"){
            System.out.println("You're moving a king.");
            checkeroo = false;
        }
        if (commonValidation(newX, newY, oldX, oldY) == false){
            checkeroo = false;
        }
        if (checkeroo == true){
            if (newX == 0){
                board[oldX][oldY].setState("king");
            }
            swap(newX, newY, oldX, oldY);
        }    
    }

    /**
     * move method for white pawn. can only go up.
     * @param newX End coordinate of the piece (row/x)
     * @param newY End coordinate of the piece (column/y)
     * @param oldX Start coordinate of the piece (row/x)
     * @param oldY Start coordinate of the piece (column/y)
     */
    public void movePawnBlack(int newX, int newY, int oldX, int oldY){
        boolean checkeroo = true;
        if ((oldY + 1 != newY && oldY - 1 != newY)){
            System.out.println("You're moving too far across");
            checkeroo = false;
        }
        if (oldX + 1 != newX){
            System.out.println("You're moving too far down");
            checkeroo = false;
        }
        if (board[oldX][oldY].getColour() != "black"){
            System.out.println("You're moving the other player's piece");
            checkeroo = false;
        }
        if (board[oldX][oldY].getState() != "pawn"){
            System.out.println("You're moving a king.");
            checkeroo = false;
        }
        if (commonValidation(newX, newY, oldX, oldY) == false){
            checkeroo = false;
        }
        if (checkeroo = true){
            if (newX == 7){
                board[oldX][oldY].setState("king");
            }
            swap(newX, newY, oldX, oldY);
        }    
    }

    /**
     * Putting the pieces onto the board.
     */
    public void initialization(){
        for (int i = 1; i < 8; i += 2){
            board[0][i] = new pieces(0, i, "black", "pawn");
            board[2][i] = new pieces(2, i, "black", "pawn");
            board[6][i] = new pieces(6, i, "white", "pawn");
        }
        for (int i = 0; i < 8; i += 2){
            board[1][i] = new pieces(1, i, "black", "pawn");
            board[5][i] = new pieces(5, i, "white", "pawn");
            board[7][i] = new pieces(7, i, "white", "pawn");
        }
    }

    /**
     * prints the board to the terminal
     */
    public void printboard(){
        System.out.println("    0   1   2   3   4   5   6   7");
        System.out.println("-----------------------------------");
        for (int i = 0; i < 8; i++){
            System.out.print(i + " | ");
        for (int j = 0; j < 8; j++){
            if (board[i][j] == null){
                System.out.print(" " + " | ");
            }
            else{
                System.out.print(board[i][j] + " | ");
            }
        }
        System.out.println();
        System.out.println("-----------------------------------");
    }
    }
 
}

