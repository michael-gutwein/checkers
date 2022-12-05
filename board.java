class board{
    pieces[][] board;
    int whiteCounter = 12;
    int blackCounter = 12;
    public board(){
        board = new pieces[8][8];
        initialization(); 
    }
    
    public int endGame(){
        if (whiteCounter <= 0){
            return 1;
        }
        else if (blackCounter <= 0){
            return 2;
        }
        return 0;
    }

    public void jumpBlackKing(int newX, int newY, int oldX, int oldY){
        if ((oldX - 2 != newX && oldX + 2 != newX) || commonValidation(newX, newY, oldX, oldY) == false){
            System.out.println("INVALID ENGLAND IS BETTER");
        }
        else{
            int checkY = newY - oldY;
            int checkX = newX - oldX;
            if (checkY == 2 && checkX == -2){
                if (board[oldX - 1][oldY + 1].colour == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY + 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("Invalid!");
                }
            }
            else if (checkY == 2 && checkX == 2) {
                if (board[oldX + 1][oldY + 1].colour == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY + 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("Invalid!");
                }
            }
            else if (checkY == -2 && checkX == -2){
                if (board[oldX - 1][oldY - 1].colour == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY - 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("Invalid");
                }
            }
            else if (checkY == -2 && checkX == 2){
                if (board[oldX + 1][oldY - 1].colour == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY - 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("Invalid");
                }
            }
            else{
                System.out.println("Invalid");
            }
        }
    }

    public void jumpWhiteKing(int newX, int newY, int oldX, int oldY){
        if ((oldX - 2 != newX && oldX + 2 != newX) || commonValidation(newX, newY, oldX, oldY) == false){
            System.out.println("INVALID ENGLAND IS BETTER");
        }
        else{
            int checkY = newY - oldY;
            int checkX = newX - oldX;
            if (checkY == 2 && checkX == -2){
                if (board[oldX - 1][oldY + 1].colour == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY + 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("Invalid!");
                }
            }
            else if (checkY == 2 && checkX == 2) {
                if (board[oldX + 1][oldY + 1].colour == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY + 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("Invalid!");
                }
            }
            else if (checkY == -2 && checkX == -2){
                if (board[oldX - 1][oldY - 1].colour == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY - 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("Invalid");
                }
            }
            else if (checkY == -2 && checkX == 2){
                if (board[oldX + 1][oldY - 1].colour == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY - 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("Invalid");
                }
            }
            else{
                System.out.println("Invalid");
            }
        }
    }

    public void moveKing(int newX, int newY, int oldX, int oldY){
        if ((oldY + 1 != newY && oldY - 1 != newY) || (oldX + 1 != newX && oldX - 1 != newX) || board[oldX][oldY].state != "king" || commonValidation(newX, newY, oldX, oldY) == false){
            System.out.println("Invalid move!");
        }
        else{
            swap(newX, newY, oldX, oldY);
        }    
    }

    public void swap(int newX, int newY, int oldX, int oldY){
        pieces temp = new pieces(board[oldX][oldY]);
        board[oldX][oldY] = board[newX][newY];
        board[newX][newY] = temp;
    }

    public void jumpPawnWhite(int newX, int newY, int oldX, int oldY){
        if (oldX - 2 != newX || commonValidation(newX, newY, oldX, oldY) == false){
            System.out.println("INVALID ENGLAND IS BETTER");
        }
        else{
            int check = newY - oldY;
            if (check == 2){
                if (board[oldX - 1][oldY + 1].colour == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY + 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("Invalid!");
                }
            }
            else if (check == -2){
                if (board[oldX - 1][oldY - 1].colour == "black"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX - 1][oldY - 1] = null;
                    blackCounter--;
                }
                else{
                    System.out.println("Invalid");
                }
            }
            else{
                System.out.println("Invalid");
            }
        }
        
    }

    public void jumpPawnBlack(int newX, int newY, int oldX, int oldY){
        if (oldX + 2 != newX || commonValidation(newX, newY, oldX, oldY) == false){
            System.out.println("INVALID ENGLAND IS BETTER");
        }
        else{
            int check = newY - oldY;
            if (check == 2){
                if (board[oldX + 1][oldY + 1].colour == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY + 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("Invalid!");
                }
            }
            else if (check == -2){
                if (board[oldX + 1][oldY - 1].colour == "white"){
                    swap(newX, newY, oldX, oldY);
                    board[oldX + 1][oldY - 1] = null;
                    whiteCounter--;
                }
                else{
                    System.out.println("Invalid");
                }
            }
            else{
                System.out.println("Invalid");
            }
        }
        
    }

    public boolean commonValidation(int newX, int newY, int oldX, int oldY){
        if (board[newX][newY] != null || newX < 0 || newX > 7 || newY < 0 || newY > 7){
            return false;
        }
        return true;
    }

    public void movePawnWhite(int newX, int newY, int oldX, int oldY){
        if ((oldY + 1 != newY && oldY - 1 != newY) || oldX - 1 != newX || board[oldX][oldY].colour != "white" || board[oldX][oldY].state != "pawn" || commonValidation(newX, newY, oldX, oldY) == false){
            System.out.println("Invalid move!");
        }
        else{
            if (newX == 0){
                board[oldX][oldY].state = "king";
            }
            swap(newX, newY, oldX, oldY);
        }    
    }

    public void movePawnBlack(int newX, int newY, int oldX, int oldY){
        if ((oldY + 1 != newY && oldY - 1 != newY) || oldX + 1 != newX || board[oldX][oldY].colour != "black" || board[oldX][oldY].state != "pawn" || commonValidation(newX, newY, oldX, oldY) == false){
            System.out.println("Invalid move!");
        }
        else{
            if (newX == 7){
                board[oldX][oldY].state = "king";
            }
            swap(newX, newY, oldX, oldY);
        }    
    }

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

