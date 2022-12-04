class board{
    private Piece[][] pieces = new Piece[8][8];

    public board(){
        initialization();
        // movePiece(0, 0, 3, 3);
    }
    public void initialization(){
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if ((j % 2 == 0 && i % 2 == 1) || (j % 2 == 1 && i % 2 == 0)) {
                    if (i == 3 || i == 4) {
                        pieces[i][j] = new Piece(' ');
                    } else if (i < 3) {
                        pieces[i][j] = new Piece('B');
                    } else {
                        pieces[i][j] = new Piece('R');
                    }
                } else {
                    pieces[i][j] = new Piece(' ');
                }
            }

        }

    }

    public boolean canMovePiece(int oldSpotI, int oldSpotJ, int newSpotI, int newSpotJ) {
        Piece oldPiece = pieces[oldSpotI][oldSpotJ];
        Piece newPiece = pieces[newSpotI][newSpotJ];
        if (oldPiece.getPiece() == 'R') {
            if (newSpotI == oldSpotI - 1
                && (newSpotJ == oldSpotJ - 1 || newSpotJ == oldSpotJ + 1)
                && newPiece.getPiece() == ' ')
            {
                return true;
            } else if (newSpotI == oldSpotI - 2
                && newSpotJ == oldSpotJ + 2
                && newPiece.getPiece() == ' '
                && pieces[oldSpotI - 1][oldSpotJ + 1].getPiece() == 'B')
            {
                pieces[oldSpotI - 1][oldSpotJ + 1].setPiece(' ');
                return true;
            } else if (newSpotI == oldSpotI - 2
                && newSpotJ == oldSpotJ - 2
                && newPiece.getPiece() == ' '
                && pieces[oldSpotI - 1][oldSpotJ - 1].getPiece() == 'B')
            {
                pieces[oldSpotI - 1][oldSpotJ - 1].setPiece(' ');
                return true;
            }
        } else if (oldPiece.getPiece() == 'B') {
            if (newSpotI == oldSpotI + 1
                && (newSpotJ == oldSpotJ - 1 || newSpotJ == oldSpotJ + 1)
                && newPiece.getPiece() == ' ')
            {
                return true;
            } else if (newSpotI == oldSpotI + 2
                && newSpotJ == oldSpotJ + 2
                && newPiece.getPiece() == ' '
                && pieces[oldSpotI + 1][oldSpotJ + 1].getPiece() == 'R')
            {
                pieces[oldSpotI + 1][oldSpotJ + 1].setPiece(' ');
                return true;
            } else if (newSpotI == oldSpotI + 2
                && newSpotJ == oldSpotJ - 2
                && newPiece.getPiece() == ' '
                && pieces[oldSpotI + 1][oldSpotJ - 1].getPiece() == 'R')
            {
                pieces[oldSpotI + 1][oldSpotJ - 1].setPiece(' ');
                return true;
            }
        }
        return false;
    }

    public void movePiece(char oldSpotX, int oldSpotY, char newSpotX, int newSpotY) {
        String charList = "ABCDEFGH";
        int oldSpotI = oldSpotY - 1;
        int newSpotI = newSpotY - 1;
        int oldSpotJ = charList.indexOf(oldSpotX);
        int newSpotJ = charList.indexOf(newSpotX);

        Piece oldPiece = pieces[oldSpotI][oldSpotJ];
        if (canMovePiece(oldSpotI, oldSpotJ, newSpotI, newSpotJ)) {
            pieces[newSpotI][newSpotJ] = new Piece(oldPiece.getPiece());
            oldPiece.setPiece(' ');
            printboard();
        } else {
            System.out.println("\nInvalid Move!");
        }
    }
    
    public void printboard(){
        System.out.println("\n\n    A   B   C   D   E   F   G   H");
        System.out.println("   --- --- --- --- --- --- --- ---");
        
        for (int i = 0; i < 8; i++){ 
         
         System.out.print(i + 1 + " | ");
         
            for (int j = 0; j < 8; j++){
                System.out.print(pieces[i][j].getPiece() + " | ");

            }
            System.out.println();
            System.out.println("   --- --- --- --- --- --- --- ---");

          }
    }


    }
