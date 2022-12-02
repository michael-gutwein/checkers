class board{
   private char[][] board;

    public board(){
        board = new char[8][8];
      initialization(); 
    }
    public void initialization(){
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                board[i][j] ='-';
            }

        }

    }
    public void printboard(){
        System.out.println("----------------------------------");
        for (int i = 0; i < 8; i++)
        {System.out.print(" | ");
        for (int j = 0; j < 8; j++)
        {
            System.out.print(board[i][j] + " | ");

        }
        System.out.println();
        System.out.println("----------------------------------");

    }


    }

}
