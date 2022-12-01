
class board{
    int col;
    int row;
    int[][] board;

    public board(int col, int row, int[][] board){
        this.col = col;
        this.row = row;
        this.board = board;
    }

    public String toString(){
        String checkerString = "";
        String rowString = "";
        for (int row = 0; row < board.length; row ++){
            for (int col = 0; col < board[row].length; col ++){
                rowString += board[row][col] + " ";
            }
            rowString = rowString.strip();
            checkerString += rowString + "\n";
            rowString = "";
        }
        checkerString = checkerString.strip();
        return checkerString;
    }

    public static void main(String[] args) {
        int[][] 
    }
}